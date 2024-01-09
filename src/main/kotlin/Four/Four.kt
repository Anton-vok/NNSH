package Four

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun Four(three: MutableState<Int>){
    Column(Modifier.fillMaxSize()){
        Button(onClick = {three.value=1}) { Text("Te") }
        Button(onClick = {three.value=2}) { Text("Le") }
        Button(onClick = {three.value=3}) { Text("ER") }

    }
}