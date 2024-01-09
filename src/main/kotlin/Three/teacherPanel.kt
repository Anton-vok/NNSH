package Three

import BackgroundOneColor
import ButtonOneColor
import ButtonTwoColor
import NNSBD
import PanelInput
import PanelOneColor
import Teacher
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import textStyle3
import textStyle4

@Composable
fun  TeacherPanel(BD: NNSBD){
    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxWidth().fillMaxHeight(0.8f).background(BackgroundOneColor)) {
            items(BD.teachers.value.chunked(2)){ teacherName ->
                Row(Modifier.fillMaxWidth().height(40.dp)){
                    Row(Modifier.weight(0.075f).fillMaxHeight()){}
                    Row(Modifier.weight(0.4f).fillMaxHeight()){teacher(teacherName[0], BD)}
                    Row(Modifier.weight(0.075f).fillMaxHeight()){}
                    Row(Modifier.weight(0.4f).fillMaxHeight()){if (teacherName.size==2)teacher(teacherName[1], BD)}
                    Row(Modifier.weight(0.075f).fillMaxHeight()){} }
                Row(Modifier.fillMaxWidth().height(20.dp)){}
            }
        }
        Row(Modifier.fillMaxWidth()){ addTeacher(BD) }
    }
}

@Composable
fun teacher(teacherName: Teacher, BD: NNSBD){
    Row(Modifier.fillMaxSize().background(PanelOneColor).border(0.dp, Color(145, 151, 153), shape = RoundedCornerShape(10.dp))){
        Row(Modifier.fillMaxWidth(0.8f).align(Alignment.CenterVertically)){ Text(teacherName.name, style = textStyle4) }
        Row(Modifier.fillMaxHeight().fillMaxWidth()){ delTeacherButton(teacherName, BD) }
    }
}

@Composable
fun addTeacher(BD: NNSBD){
    Column(Modifier.fillMaxSize()){
        Row(Modifier.fillMaxWidth().fillMaxHeight(0.1f)) {}
        Row(Modifier.fillMaxWidth().fillMaxHeight(0.7f)) {
            Row(Modifier.weight(0.3f).fillMaxHeight()) {}
            Row(Modifier.background(PanelOneColor).weight(0.4f).fillMaxHeight()) {
                var teacher = remember {  mutableStateOf("") }
                Row(Modifier.fillMaxWidth(0.8f)){ PanelInput(teacher) }
                Row(Modifier.fillMaxWidth()){ addTeacherButton(teacher, BD) }
            }
            Row(Modifier.weight(0.3f).fillMaxHeight()) {}
        }
        Row(Modifier.fillMaxWidth().fillMaxHeight(0.2f)) {}
    }
}

@Composable
fun addTeacherButton(teacher: MutableState<String>, BD: NNSBD){
    Surface(
        modifier = Modifier
            .fillMaxSize(1f)
            .clickable(onClick = {
                if (teacher.value!=""){
                    BD.addTeacher(teacher.value)
                    teacher.value=""
                }
            }),
        color = ButtonOneColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center) {
            Text("Добавить")
        }
    }
}

@Composable
fun delTeacherButton(teacher: Teacher, BD: NNSBD){
    Surface(
        modifier = Modifier
            .fillMaxSize(1f)
            .clickable(onClick = {
                BD.delTeacher(teacher)
            }),
        color = ButtonTwoColor,
        contentColor = Color.White,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center) {
            Text("del")
        }
    }
}