import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var shape = 15.dp

var BackgroundOneColor= Color(0xFFC9E4EA)
var BackgroundTwoColor= Color(0xFFF5F5F5)

var TextColor= Color(0xFF333333)

var ButtonOneColor= Color(0xFF1E73FF)
var ButtonTwoColor= Color(0xFFFF8A80)

var PanelOneColor= Color(0xFFFFFFFF)

var textStyle1=TextStyle(
    fontFamily = FontFamily.SansSerif,
    color = TextColor,
    fontSize = 35.sp,
    fontWeight = FontWeight.Bold
)

var textStyle2=TextStyle(
    fontFamily = FontFamily.SansSerif,
    color = TextColor,
    fontSize = 28.sp,
    fontWeight = FontWeight.Bold
)

var textStyle3=TextStyle(
    fontFamily = FontFamily.SansSerif,
    color = TextColor,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold
)

var textStyle4=TextStyle(
    fontFamily = FontFamily.SansSerif,
    color = TextColor,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold
)

var textStyle5=TextStyle(
    fontFamily = FontFamily.SansSerif,
    color = TextColor,
    fontSize = 12.sp,
    fontWeight = FontWeight.Bold
)