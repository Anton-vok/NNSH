package Two

import ButtonOneColor
import Lesson
import NNSBD
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

@Composable
fun addLesson(BD: NNSBD){

    var name = remember { mutableStateOf("") }
    var teacher= remember { mutableStateOf("") }

    var day = remember { mutableStateOf("") }
    var startOne = remember { mutableStateOf("") }
    var endOne = remember { mutableStateOf("") }
    var startTwo = remember { mutableStateOf("") }
    var endTwo = remember { mutableStateOf("") }

    var lessons = mutableListOf(remember { mutableStateOf("") }, remember { mutableStateOf("") }, remember { mutableStateOf("") }, remember { mutableStateOf("") })

    var expandedTwo = remember { mutableStateOf(false) }
    var expandedOne = remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()){

        Row(Modifier.weight(0.1f).wrapContentSize(Alignment.Center)){
            Text(style = textStyle2, text="Добавить урок")
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
                Row(Modifier.weight(0.1f)){}
                Row(Modifier.weight(0.8f)) {
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
                            }),
                        color = ButtonOneColor,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Box(Modifier.fillMaxSize(1f),
                            contentAlignment = Alignment.Center) {
                            Text("Сохранить")
                        }
                    }
                }
                Row(Modifier.weight(0.1f)){}
            }
            Row(Modifier.fillMaxHeight(0.1f)){}
        }
    }
}