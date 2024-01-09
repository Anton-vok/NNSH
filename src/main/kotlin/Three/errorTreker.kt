package Three

import Lesson
import NNSBD
import One.day
import PanelOneColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import textStyle2
import textStyle3


@Composable
fun er(BD: NNSBD){
    LazyColumn(Modifier.fillMaxSize()) {
        items(BD.errors.value.chunked(2)) { er ->
            Row(Modifier.height(150.dp)){
                Row(Modifier.weight(0.075f)){}

                Row(Modifier.weight(0.4f)){
                    prError(er[0])
                }

                Row(Modifier.weight(0.075f)){}

                Row(Modifier.weight(0.4f)){
                    if (er.size>1){
                        prError(er[1])
                    }
                }

                Row(Modifier.weight(0.075f)){}
            }
        }
    }
}

@Composable
fun prError(er: Pair<Lesson, Lesson>){
    Column(Modifier.fillMaxSize().background(PanelOneColor)){
        Text("Конфликт", style = textStyle2)
        Text("Учитель:${er.first.teacher}")
        Column(Modifier.fillMaxHeight(0.4f)){
            Text(er.first.name, style = textStyle3)
            Text("День-${er.first.day}, ${er.first.timeStart/60}:${er.first.timeStart%60} - ${er.first.timeEnd/60}:${er.first.timeEnd%60}", style = textStyle3)
        }
        Column(Modifier.fillMaxHeight(0.3f)){}
        Column(Modifier.fillMaxHeight()){
            Text(er.second.name, style = textStyle3)
            Text("День-${er.second.day}, ${er.second.timeStart/60}:${er.second.timeStart%60} - ${er.second.timeEnd/60}:${er.second.timeEnd%60}", style = textStyle3)
        }
    }
}