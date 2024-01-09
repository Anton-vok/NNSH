package Two

import ButtonOneColor
import ButtonTwoColor
import Lesson
import NNSBD
import One.classroom
import PanelInput
import PanelInputTwo
import PanelOneColor
import SelectPanel
import Timing
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import textStyle2
import textStyle3
import twoPanelRe

@Composable
fun ReLesson(BD: NNSBD, lesson: Lesson){

    var name = remember { mutableStateOf(lesson.name) }
    var teacher= remember { mutableStateOf(lesson.teacher) }

    var day = remember { mutableStateOf(lesson.day.toString()) }
    var startOne = remember { mutableStateOf((lesson.timeStart/60).toString()) }
    var endOne = remember { mutableStateOf((lesson.timeEnd/60).toString()) }
    var startTwo = remember { mutableStateOf((lesson.timeStart%60).toString()) }
    var endTwo = remember { mutableStateOf((lesson.timeEnd%60).toString()) }

    var lessons = mutableListOf<MutableState<String>>()
    for (i in lesson.classRoom){
        lessons.add(remember { mutableStateOf( i.toString()) })
    }
    while (lessons.size < 4) {
        lessons.add(remember { mutableStateOf( "" ) })
    }

    var expandedTwo = remember { mutableStateOf(false) }
    var expandedOne = remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Row(Modifier.fillMaxWidth(0.95f)){ Text(style = textStyle2, text="Редактировать урок") }
            Row(Modifier.fillMaxWidth(1f)){ Button(onClick = { twoPanelRe.value=false }){ Text("X") } }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Название урока", style = textStyle3)
                PanelInputTwo(name, expandedOne)
                SelectPanel(name, BD.lessonType.value, expandedOne)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Классы")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            for (i in 0..3){
                Row(Modifier.weight(0.05f).wrapContentSize(Alignment.Center)){}
                Row(Modifier.weight(0.2f).wrapContentSize(Alignment.Center)){
                    PanelInput(lessons[i])
                }
            }
        }

        Row(Modifier.weight(0.160f).wrapContentSize(Alignment.Center)){
            Column {
                Text("Учитель", style = textStyle3)
                if (lessons[0].value!="" && name.value!="" && lessons[0].value.toIntOrNull()!=null && teacher.value==""){
                    BD.findLesTea(name.value, lessons[0].value.toInt(), teacher)
                }
                PanelInputTwo(teacher, expandedTwo)
                SelectPanel(teacher, BD.teachers.value, expandedTwo)
            }
        }

        Row(Modifier.weight(0.08f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle3, text="Дата и время")
        }

        Row(Modifier.weight(0.130f).wrapContentSize(Alignment.Center)){
            Row(Modifier.weight(0.15f).background(PanelOneColor)){ PanelInput(day) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(startOne, startTwo) }
            Row(Modifier.weight(0.125f)){}
            Row(Modifier.weight(0.30f)){ Timing(endOne, endTwo) }
        }

        Column (Modifier.weight(0.16f).wrapContentSize(Alignment.Center)) {
            Row(Modifier.fillMaxHeight(0.1f)){}
            Row(Modifier.fillMaxHeight(0.8f)) {
                Row(Modifier.fillMaxWidth(0.45f)) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .clickable(onClick = {
                                var classrooms= mutableListOf<Int>()
                                for (i in lessons){
                                    if (i.value!=""){
                                        classrooms.add(i.value.toInt())
                                    }
                                }
                                if (name.value!="" &&
                                    day.value.toIntOrNull()!=null &&
                                    !classrooms.isEmpty() &&
                                    teacher.value!="" &&
                                    startOne.value.toIntOrNull()!=null &&
                                    startTwo.value.toIntOrNull()!=null &&
                                    endOne.value.toIntOrNull()!=null &&
                                    endTwo.value.toIntOrNull()!=null

                                ) {
                                    BD.del(lesson)
                                    BD.add(
                                        Lesson(
                                            name.value,
                                            day.value.toInt(),
                                            classrooms,
                                            teacher.value,
                                            startOne.value.toInt() * 60 + startTwo.value.toInt(),
                                            endOne.value.toInt() * 60 + endTwo.value.toInt()
                                        )
                                    )
                                    name.value = ""
                                    day.value = ""
                                    for (i in lessons){
                                        i.value=""
                                    }
                                    teacher.value = ""
                                    startOne.value = ""
                                    startTwo.value = ""
                                    endOne.value = ""
                                    endTwo.value = ""
                                }
                                twoPanelRe.value=false
                            }),
                        color = ButtonOneColor,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Box(Modifier.fillMaxSize(1f),
                            contentAlignment = Alignment.Center) {
                            Text("Edit")
                        }
                    }

                }
                Row(Modifier.fillMaxWidth(0.1f)) {}
                Row(Modifier.fillMaxWidth()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .clickable(onClick = {
                                BD.del(lesson)
                                twoPanelRe.value=false }),
                        color = ButtonTwoColor,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Box(Modifier.fillMaxSize(1f),
                            contentAlignment = Alignment.Center) {
                            Text("Del")
                        }
                    }
                }
            }
    Row(Modifier.fillMaxHeight(0.1f)){}
        }
    }
}