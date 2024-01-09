package One

import BackgroundOneColor
import Lesson
import NNBD
import NNSBD
import PanelOneColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import textStyle2
import textStyle3
import textStyle5
import twoPanelRe
import twoPanelReVale

@Composable
fun ScheduleBlock(BD: NNSBD){
    var i=1
    LazyColumn(Modifier.fillMaxSize()) {
        items(BD.Schedule) { message ->
            day(message, i)
            Row(Modifier.fillMaxWidth().height(20.dp)){}
            i+=1
        }
    }
}

@Composable
fun day(a : Array<MutableState<List<Lesson>>>, day: Int){
    Column(Modifier.fillMaxWidth().background(BackgroundOneColor), horizontalAlignment = Alignment.CenterHorizontally) { Text("День ${day}", style = textStyle2) }
    Row(Modifier.fillMaxWidth().background(BackgroundOneColor)){
        var classroom=1
        for (i in a){
            var w=0.7f/ NNBD.classroomInt.toFloat()
            var ww=0.3f/ NNBD.classroomInt.toFloat()
            Box(Modifier.weight(ww)) {}
            Box(Modifier.weight(w)) {
                classroom(i,classroom)
            }
            classroom+=1
        }
    }
}

@Composable
fun classroom(a : MutableState<List<Lesson>>, classroom: Int){
    Column {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "${classroom} класс",
                style = textStyle3
            )
        }
        Column() {
            var time = 480
            var height = 0
            for (i in a.value) {
                if (time < i.timeStart) {
                    height = i.timeStart - time
                    time = i.timeEnd
                } else {
                    height = 0
                }
                Row(Modifier.fillMaxWidth().height(height.dp)) {}
                lesson(i)
            }
        }
    }
}

@Composable
fun lesson(a : Lesson){
    var w=0
    if (a.timeStart>=a.timeEnd){
        w=5
    } else { w=a.timeEnd-a.timeStart }
    Surface(
        Modifier.
        fillMaxWidth().height(w.dp)
            .clickable(onClick = {
                twoPanelRe.value=false
                twoPanelReVale.value=a
                twoPanelRe.value=true
            })
            .border(2.dp, a.color, shape = RoundedCornerShape(10.dp)),
        color = PanelOneColor,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center) {
            Column {
                Text(a.name, style = textStyle5)
                Text("${a.timeStart / 60}:${a.timeStart % 60}-${a.timeEnd / 60}:${a.timeEnd % 60}", style = textStyle5)
            }
        }
    }
}