package Three

import BackgroundOneColor
import BackgroundTwoColor
import ButtonOneColor
import Lesson
import LessonType
import NNSBD
import One.day
import PanelInput
import PanelInputTwo
import PanelOneColor
import SelectPanel
import Teacher
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import textStyle1
import textStyle2
import textStyle3
import textStyle5

@Composable
fun LessonPanel(BD: NNSBD){
    var h=BD.classroomInt/6
    if (BD.classroomInt%6!=0){ h+=1 }
    h*=60
    h+=115

    //TODO убрать костыль

    Column(Modifier.fillMaxSize()) {
        var nya= mutableListOf("")
        Text("Уроки", style = textStyle1)
        LazyColumn(Modifier.fillMaxSize()) {
            items(nya){lesson ->
                for (i in BD.lessonType.value){
                    Row(Modifier.fillMaxWidth().height(h.dp)) {
                        Row(Modifier.weight(0.05f).height(h.dp)) {}
                        Row(Modifier.weight(0.9f).height(h.dp)) { LessonIn(i, BD) }
                        Row(Modifier.weight(0.05f).height(h.dp)) {}
                    }
                    Row(Modifier.fillMaxWidth().height(10.dp)) {}
                }
                Row(Modifier.fillMaxWidth().height(h.dp)) {
                    Row(Modifier.weight(0.05f).height(h.dp)) {}
                    Row(Modifier.weight(0.9f).height(h.dp)) { addLesson(BD) }
                    Row(Modifier.weight(0.05f).height(h.dp)) {}
                }
            }
        }
    }
}


@Composable
fun LessonIn(lesson: LessonType, BD: NNSBD){

    Column(Modifier.fillMaxSize().background(PanelOneColor)){
        Text(lesson.name, style = textStyle2)
        Column(Modifier.fillMaxSize()){
            Row(Modifier.height(5.dp)){}
            Column(Modifier.fillMaxHeight(0.7f)){
                for (i in lesson.teacherList.chunked(6)){
                    Row(Modifier.fillMaxWidth().height(50.dp)){
                        for (j in 0..6){
                            if (i.size-1>=j){
                                Box(Modifier.fillMaxHeight().weight(0.13f).background(BackgroundTwoColor)){Text(i[j].name, style = textStyle3)}
                                Box(Modifier.fillMaxHeight().weight(0.03f)){}
                            } else { Box(Modifier.fillMaxHeight().weight(0.16f)){} }
                        }
                    }
                    Row(Modifier.height(10.dp)){}
                }
                Column(Modifier.height(5.dp)){  }
            }
            Row(Modifier.height(5.dp)){}
            Column(Modifier.fillMaxHeight()){

            }
        }
    }
}


@Composable
fun addLesson(BD: NNSBD){
    var h=BD.classroomInt/6
    if (BD.classroomInt%6!=0){ h+=1 }
    h*=40
    var list=MutableList(BD.classroomInt){ remember {  mutableStateOf("") }}
    var listTwo=MutableList(BD.classroomInt){ remember {  mutableStateOf(false) }}
    var name= remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), shape = RoundedCornerShape(15.dp), color = PanelOneColor) {
        Row(Modifier.fillMaxSize()) {
            Row(Modifier.weight(0.01f)){}
            Column(modifier = Modifier.weight(0.98f)) {
                Text("Добавить урок", style = textStyle2)
                Row(Modifier.height(35.dp).width(250.dp)) { PanelInput(name) }
                var ii=0
                Column(Modifier.fillMaxHeight(0.8f)){
                    for (i in list.chunked(6)){
                        Row(Modifier.height(55.dp)) {
                            for (j in 0..6) {
                                if (i.size - 1 >= j) {
                                    Column(Modifier.weight(0.13f)){
                                        Text("Класс ${j+1+(ii*6)}", style = textStyle5)
                                        PanelInputTwo(i[j], listTwo[j+(ii*6)])
                                        SelectPanel(i[j], BD.teachers.value, listTwo[j+(ii*6)])
                                    }
                                    Row(Modifier.weight(0.03f)){}
                                } else {Row(Modifier.weight(0.16f)){}}
                            }
                        }
                        Row(Modifier.height(5.dp)) {}
                        ii+=1
                    }
                }
                Column(Modifier.fillMaxSize()){
                    Row(Modifier.fillMaxHeight(0.05f)){}
                    Row(Modifier.fillMaxHeight(0.8f)){
                        Row(Modifier.weight(0.3f)){}
                        Row(Modifier.weight(0.4f)) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize(1f)
                                    .clickable(onClick = {
                                        var tr = true
                                        var dopList = mutableListOf<Teacher>()
                                        for (i in list) {
                                            if (i.value == "") {
                                                tr = false
                                            } else {
                                                dopList.add(Teacher(i.value))
                                            }
                                        }
                                        if (name.value==""){tr=false}
                                        if (tr) {
                                            BD.addLessonType(LessonType(dopList, name.value))
                                            for (i in list){
                                                i.value=""
                                            }
                                            name.value =""
                                        }
                                    }),
                                color = ButtonOneColor,
                                contentColor = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Box(
                                    Modifier.fillMaxSize(1f),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Добавить")
                                }
                            }
                        }
                        Row(Modifier.weight(0.3f)){}
                    }
                    Row(Modifier.fillMaxHeight(0.1f)){}
                }
            }
            Row(Modifier.weight(0.01f)){}
        }
    }
}

fun delLessonButton(){

}