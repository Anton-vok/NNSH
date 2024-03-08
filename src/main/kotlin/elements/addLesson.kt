package elements

import NNSBD
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun newAddLesson(BD:NNSBD){
    Column(Modifier.fillMaxSize().padding(10.dp)){
        Row(Modifier.fillMaxWidth().weight(0.22f), horizontalArrangement = Arrangement.End){
            Box(Modifier.aspectRatio(1f).fillMaxHeight()){
                NewPanelInput(mutableStateOf(""))
            }
            Box(Modifier.weight(0.05f))
            Box(Modifier.aspectRatio(1f).fillMaxHeight()){
                NewPanelInput(mutableStateOf(""))
            }
            Box(Modifier.weight(0.05f))
            Box(Modifier.fillMaxWidth().fillMaxHeight()){
                NewPanelInput(mutableStateOf(""))
            }
        }
    }
}

