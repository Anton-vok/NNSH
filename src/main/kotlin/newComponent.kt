import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup


class textButtonStyle{
    var color = mutableStateOf(ButtonOneColor)
    var textStyle= mutableStateOf(textStyle4)
    var blur= mutableStateOf(0)
    var shape= mutableStateOf(5)
    var alpha = mutableStateOf(1)
}

@Composable
fun textButton(
    onClick: () -> Unit,
    text: MutableState<String> = mutableStateOf(""),
    style: textButtonStyle = textButtonStyle(),
    clicked: MutableState<Boolean> = mutableStateOf(true)
){
    Surface(
        modifier = Modifier
            .fillMaxSize(1f)
            .clickable(onClick = if(clicked.value){onClick} else{{}})
            .blur(style.blur.value.dp)
            .alpha(alpha = style.alpha.value.toFloat()),
        color = style.color.value,
        shape = RoundedCornerShape(style.shape.value.dp)
    ){
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text.value, style = style.textStyle.value)
        }
    }
}


class NewPanelInputStyle{
    var textStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        color = TextColor,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
    var focusColor = mutableStateOf(Color(115, 32, 239))
    var dontFocusColor = mutableStateOf(Color(145, 151, 153))
    var singleLine = true
    var shape = 4.dp
}

@Composable
fun NewPanelInput(
    endOne: MutableState<String>,
    myFocus: MutableState<Boolean> = mutableStateOf(false),
    style: NewPanelInputStyle = NewPanelInputStyle() ){

    var colorDay= if(myFocus.value) style.focusColor.value else style.dontFocusColor.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, colorDay, shape = RoundedCornerShape(style.shape))
            .background(PanelOneColor)
    ) {
        BasicTextField(
            value = endOne.value,
            onValueChange = { endOne.value = it },
            Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(vertical = 8.dp)
                .onFocusChanged { focusState -> myFocus.value = focusState.isFocused },
            singleLine = style.singleLine,
            textStyle = style.textStyle
        )
    }
}

@Composable
fun NewSelectPanel(
    onItemSelected: MutableState<String>,
    allSuggestions: MutableState<List<String>>,
    expanded: MutableState<Boolean>,
    style: textButtonStyle = textButtonStyle()
) {
    Column {
        if (expanded.value) {
            val filter=allSuggestions.value.filter { it.contains(onItemSelected.value, ignoreCase = true) }.toMutableList()
            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = { expanded.value = false }
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(0.16f).heightIn(max = 100.dp).background(MaterialTheme.colors.background)
                ) {
                    items(filter){suggestion ->
                        Box(Modifier.fillMaxWidth().height(25.dp)){
                            textButton(
                                {onItemSelected.value = suggestion
                                    expanded.value = false },
                                mutableStateOf(suggestion),
                                style
                            )
                        }
                    }
                }
            }
        }
    }
}