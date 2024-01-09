import Four.Four
import One.ScheduleBlock
import Three.LessonPanel
import Two.ReLesson
import Three.TeacherPanel
import Three.er
import Two.addLesson
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

var twoPanelRe = mutableStateOf(false)
var twoPanelReVale = mutableStateOf(Lesson("",1, mutableListOf(1), "", 1, 1))

var three = mutableStateOf(2)

@Composable
fun mainBox(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PanelOneColor)
    ){
        segmentOne()
        Divider(Modifier.fillMaxWidth(), color=TextColor, thickness = 2.dp)
        Row(Modifier.fillMaxWidth().fillMaxHeight(1f)){
            segmentTwo()
            pad(0.002f)
            segmentThree()
            pad(0.03f)
            segmentFour()
        }
    }
}

@Composable
fun pad(a: Float){
    Row(Modifier.fillMaxHeight().fillMaxWidth(a).background(TextColor)){}
}

@Composable
fun segmentOne(){
    Row(Modifier
        .fillMaxHeight(0.6f)
        .background(BackgroundTwoColor)

    ){
        ScheduleBlock(NNBD)
    }
}

@Composable
fun segmentTwo() {
    Row(
        Modifier
            .fillMaxWidth(0.18f)
            .background(BackgroundOneColor)
    ) {
        Box(Modifier.fillMaxWidth(0.04f)){}
        Box(Modifier.fillMaxWidth(0.95f)) {
            if (twoPanelRe.value){ ReLesson(NNBD, twoPanelReVale.value) }else{ addLesson(NNBD) }
        }
        Box(Modifier.fillMaxWidth(0.01f)){}
    }
}

@Composable
fun segmentThree(){
    Row(Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.92f)
        .background(BackgroundOneColor)
    ){
        if (three.value == 1){TeacherPanel(NNBD)}
        if (three.value == 2){LessonPanel(NNBD)}
        if (three.value == 3){ er(NNBD) }
    }
}

@Composable
fun segmentFour(){
    Row(Modifier
        .fillMaxHeight(1f)
        .fillMaxWidth()
        .background(BackgroundOneColor)
    ){
        Four(three)
    }
}