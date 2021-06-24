package io.github.rezaiyan.wire.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Vazir = FontFamily(Font(R.font.vazir_medium))

val MyTypography = Typography(
  h1 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 96.sp
  ),
  h2 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 60.sp
  ),
  h3 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 42.sp
  ),
  h4 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 36.sp
  ),
  h5 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 30.sp
  ),
  h6 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 16.sp
  ),
  caption = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W300,
    fontSize = 14.sp
  ),
  body1 = TextStyle(
    fontFamily = Vazir,
    fontWeight = FontWeight.W600,
    fontSize = 16.sp
  )

)

val primaryGreen = Color(0XFF0097A7)
val primaryCharcoal = Color(0xFF2b2b2b)
val accentAmber = Color(0xFFffe400)

val textColorLight = Color(0xDCFFFFFF)
val textColorDark = Color(0xFFf3f3f3)
val gridLineColorLight = Color.Black
val lightGrey = Color.White
val lightGreyAlpha = Color(0xFFf3f3f3)

private val LightColorPalette = lightColors(
  primary = Color(0XFF00BCD4),
  secondary = Color(0XFFFFFFFF),
  surface = Color(0XFF757575),
  primaryVariant = Color(0XFF212121),
  onPrimary = Color(0XFFFFFFFF),
  onSurface = Color(0XFF757575)
)

private val DarkColorPalette = darkColors(
  //main background color
  primary = Color(0XFF0097A7),
  secondary = Color(0XFFFFFFFF),
  surface = Color(0XFF757575),
  primaryVariant = Color(0XFF212121),
  onPrimary = Color(0XFFFFFFFF),
  onSurface = Color(0XFF757575)

)

@Composable
fun WireTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {

  MaterialTheme(
    colors = if (darkTheme) DarkColorPalette else LightColorPalette,
    typography = MyTypography,
    content = content
  )
}
