import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
var NNBD=NNSBD(6, 11)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        //mainBox()
        //testNew()
        newMainBox(NNBD)
    }
}
