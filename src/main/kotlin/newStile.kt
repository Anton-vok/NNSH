import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val white = Color(0xFFFFFFFF)
val grayLight = Color(0xFFF9F9F9)
val black = Color(0xFF000000)
val grayDark = Color(0xFF333333)
val blue = Color(0xFF1E73FF)
val red = Color(0xFFFF8A80)

class StyleColor(
    var dark:MutableState<Boolean> = mutableStateOf(false)
){
    var headers = if (dark.value) white else black
    var text = if (dark.value) grayLight else grayDark
    var panelOne = if (dark.value) black else white
    var panelTwo = if (dark.value) grayDark else grayLight
    var mainColor = blue
    var contrastColor = red
}

class StyleText(
    var sc: StyleColor = StyleColor()
){
    var h1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        color = sc.headers,
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold
    )
    var h2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        color = sc.headers,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
    var text = TextStyle(
        fontFamily = FontFamily.SansSerif,
        color = sc.text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
    var input = TextStyle(
        fontFamily = FontFamily.SansSerif,
        color = sc.text,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}