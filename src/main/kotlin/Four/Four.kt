package Four

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Four(three: MutableState<Int>){
    Column(Modifier.fillMaxSize().padding(10.dp)){
        Box(Modifier.fillMaxWidth().background(Color(0xFFF7F7F7), shape = RoundedCornerShape(30.dp)).aspectRatio(1f)
            .clickable { three.value=1 },
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource("grope.svg"),
                contentDescription = "Te"
            )
        }

        Box(Modifier.height(10.dp))

        Box(Modifier.fillMaxWidth().background(Color(0xFFF7F7F7), shape = RoundedCornerShape(30.dp)).aspectRatio(1f)
            .clickable { three.value=2 },
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource("book.svg"),
                contentDescription = "Le"
            )
        }

        Box(Modifier.height(10.dp))

        Box(Modifier.fillMaxWidth().background(Color(0xFFF7F7F7), shape = RoundedCornerShape(30.dp)).aspectRatio(1f)
            .clickable { three.value=3 },
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource("error.svg"),
                contentDescription = "Re"
            )
        }

    }
}
@Composable
fun TestFour(three: MutableState<Int>){
    Row(Modifier.fillMaxSize()){
        Button(onClick = {three.value=1}) { Text("Te") }
        Button(onClick = {three.value=2}) { Text("Le") }
        Button(onClick = {three.value=3}) { Text("ER") }
    }
}