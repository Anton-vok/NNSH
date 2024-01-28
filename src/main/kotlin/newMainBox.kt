import Four.TestFour
import One.ScheduleBlock
import Two.addLesson
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun newMainBox(BD: NNSBD){
    Column(Modifier.fillMaxSize()){
        Box(Modifier.fillMaxWidth().weight(0.05f).background(Color.Red)){
            //One
            //test ild panel
            TestFour(mutableStateOf(1))
        }
        Row(Modifier.fillMaxWidth().weight(0.95f)){
            Column(Modifier.fillMaxHeight().weight(0.25f)){
                Box(Modifier.fillMaxWidth().weight(0.375f).background(Color.Gray)){
                    //Two
                    //test old panel
                    addLesson(BD)
                }
                Box(Modifier.fillMaxWidth().weight(0.575f).background(Color.Yellow)){
                    //Three
                }
                Box(Modifier.fillMaxWidth().weight(0.05f).background(Color.Green)){
                    //Four
                }
            }
            Box(Modifier.fillMaxHeight().weight(0.75f).background(Color.Blue)){
                //five
                //test old panel
                ScheduleBlock(BD)
            }
        }
    }
}