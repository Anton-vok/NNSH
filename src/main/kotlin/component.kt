import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun PanelInput(endOne: MutableState<String>){
    var FocusDay by remember { mutableStateOf(false) }
    var colorDay=if(FocusDay) Color(115, 32, 239) else Color(145, 151, 153)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, colorDay, shape = RoundedCornerShape(4.dp))
                .background(PanelOneColor)
        ) {
            BasicTextField(
                value = endOne.value,
                onValueChange = { endOne.value = it },
                Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 8.dp)
                    .onFocusChanged { focusState -> FocusDay = focusState.isFocused },
                singleLine = true,
                textStyle = textStyle4
            )

    }
}

@Composable
fun PanelInputTwo(endOne: MutableState<String>, myFocus: MutableState<Boolean>){
    var FocusDay by remember { mutableStateOf(false) }
    var colorDay=if(FocusDay) Color(115, 32, 239) else Color(145, 151, 153)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, colorDay, shape = RoundedCornerShape(4.dp))
            .background(PanelOneColor)
    ) {
        BasicTextField(
            value = endOne.value,
            onValueChange = {
                endOne.value = it },
            Modifier
                .align(Alignment.Center)
                .padding(vertical = 8.dp)
                .onFocusChanged {
                    focusState -> FocusDay = focusState.isFocused
                    myFocus.value = focusState.isFocused},
            singleLine = true,
            textStyle = textStyle4
        )

    }
}



@Composable
fun Timing(One: MutableState<String>, Two: MutableState<String>){
    Row(Modifier.fillMaxSize().background(BackgroundTwoColor).border(1.dp, Color(145, 151, 153), shape = RoundedCornerShape(4.dp))
    ){
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
                PanelInput(One)
        }
        Box(Modifier.weight(0.20f).fillMaxHeight(), contentAlignment = Alignment.Center){
            Text(":", style = textStyle3)
        }
        Row(Modifier.weight(0.40f).background(PanelOneColor)){
            PanelInput(Two)
        }
    }
}

@Composable
fun SelectPanel(
    onItemSelected: MutableState<String>,
    allSuggestions: List<ToSelectPanel>,
    expanded: MutableState<Boolean>
) {
    Column {
        if (expanded.value) {
            val filteredSuggestions = allSuggestions.filter { it.name.contains(onItemSelected.value, ignoreCase = true) }
            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = { expanded.value = false }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.16f).heightIn(max = 100.dp).background(MaterialTheme.colors.background)
                ) {
                    for (suggestion in filteredSuggestions) {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .clickable {
                                    onItemSelected.value = suggestion.name
                                    expanded.value = false
                                }
                                .padding(8.dp)
                        ) {
                            Text(suggestion.name)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorPicer(color: Color){
    
}