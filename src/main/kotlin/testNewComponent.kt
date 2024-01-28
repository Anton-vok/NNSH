import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun testNew(){
    class to(tex:String):ToSelectPanel{
        override var name = tex
    }
    var text= mutableStateOf("")
    var textBool= mutableStateOf(false)
    var listText= mutableStateOf(listOf("bbb"))
    var style = textButtonStyle()
    style.textStyle = mutableStateOf(textStyle4)
    style.shape = mutableStateOf(5)
    style.color = mutableStateOf(Color(0xFFD9D9D9))
    var dopText= mutableStateOf("")

    Row(Modifier.fillMaxWidth().height(500.dp)){
        Column(Modifier.fillMaxHeight().weight(0.5f)){
            Box(Modifier.fillMaxWidth().height(100.dp)){
                NewPanelInput(text, textBool)
            }
            NewSelectPanel(text, listText, textBool, style)
            Box(Modifier.fillMaxWidth().height(100.dp).background(Color.Blue))
        }
        Column(Modifier.fillMaxHeight().weight(0.5f)){
            Box(Modifier.fillMaxWidth().weight(0.5f)){
                NewPanelInput(dopText)
            }
            Box(Modifier.fillMaxWidth().weight(0.5f)){
                textButton({
                    listText.value+=dopText.value
                })
            }
        }
    }
}