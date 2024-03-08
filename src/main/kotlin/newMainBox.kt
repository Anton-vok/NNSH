import Four.TestFour
import One.ScheduleBlock
import Three.LessonPanel
import Two.addLesson
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import elements.newAddLesson

@Composable
fun newMainBox(BD: NNSBD){
    Column(Modifier.fillMaxSize()){
        Box(Modifier.fillMaxWidth().weight(0.05f)){
            //One
            //test ild panel
            TestFour(mutableStateOf(1))
        }
        Divider(Modifier.fillMaxWidth().height(3.dp).background(Color.Black))
        Row(Modifier.fillMaxWidth().weight(0.95f)){
            Column(Modifier.fillMaxHeight().weight(0.25f)){
                Box(Modifier.fillMaxWidth().weight(0.375f)){
                    //Two
                    //test old panel
                    newAddLesson(BD)
                }
                Divider(Modifier.fillMaxWidth().height(3.dp).background(Color.Black))
                Box(Modifier.fillMaxWidth().weight(0.575f)){
                    //Three
                    //test old panel
                    LessonPanel(BD)
                }
                Divider(Modifier.fillMaxWidth().height(3.dp).background(Color.Black))
                Box(Modifier.fillMaxWidth().weight(0.05f)){
                    //Four
                    Text("More error", style = textStyle2)
                }
            }
            Divider(Modifier.fillMaxHeight().width(3.dp).background(Color.Black))
            Box(Modifier.fillMaxHeight().weight(0.75f)){
                //five
                //test old panel
                ScheduleBlock(BD)
            }
        }
    }
}