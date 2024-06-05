package io.padam.android_ui.customer.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import io.padam.android_ui.customer.PadamUI

// - Primary Colors

val Color.Companion.PUIPrimary: Color
    get() { return PadamUI.defaultPrimaryColor }

val Color.Companion.PUIPrimaryLight: Color
    get() { return Color.PUIPrimary.adjustByAdding(saturation = -.2f ,luminance = .2f) }

val Color.Companion.PUIPrimaryDark: Color
    get() { return Color.PUIPrimary.adjustByAdding(luminance = -.2f) }


// - Backgrounds

val Color.Companion.PUIBackground: Color
    get() = Color(0xFFFEFEFE)

val Color.Companion.PUIBackgroundGray: Color
    get() = Color(0xFFF4F4F4)

val Color.Companion.PUIForeground: Color
    get() = Color(0XFFFFFFFF)

val Color.Companion.PUIBackgroundBlue: Color
    get() = Color(0xFFD7E7F2)

val Color.Companion.PUIBackgroundRed: Color
    get() = Color(0xFFF8D9DD)

val Color.Companion.PUIBackgroundGreen: Color
    get() = Color(0x4D1FA769)

val Color.Companion.PUIBackgroundYellow: Color
    get() = Color(0xFFFFF1C4)


// - Texts

val Color.Companion.PUILabel: Color
    get() = Color(0xFF101010)

val Color.Companion.PUILabelGray: Color
    get() = Color(0xff424242)

val Color.Companion.PUILabelBlue: Color
    get() = Color(0xFF0869AF)

val Color.Companion.PUILabelRed: Color
    get() = Color(0xFFD0021B)

val Color.Companion.PUILabelGreen: Color
    get() = Color(0xFF46826B)

val Color.Companion.PUILabelYellow: Color
    get() = Color(0xFF786F1D)

// Gray Scale

val Color.Companion.PUIGray1: Color
    get() = Color(0xFF717587)

val Color.Companion.PUIGray2: Color
    get() = Color(0xFF6C6C6C)

val Color.Companion.PUIGray3: Color
    get() = Color(0xFF404148)

val Color.Companion.PUIGray4: Color
    get() = Color.PUILabel

// Accessibility

val Color.contrastedShadeColor: Color
    get() {
        return if (contrastRatioWith(Color.Black) > contrastRatioWith(Color.White)) Color.Black else Color.White
    }

private fun Color.lum(value: Double): Double {
    return if (value <= 0.03928) value / 12.92 else Math.pow((value + 0.055) / 1.055, 2.4)
}

private val Color.luminance: Double
    get() {
        val rLum = 0.2126 * lum(this.red.toDouble())
        val gLum = 0.7152 * lum(this.green.toDouble())
        val bLum = 0.0722 * lum(this.blue.toDouble())
        return rLum + gLum + bLum
    }

private fun Color.contrastRatioWith(color: Color): Double {
    val ratio = (this.luminance + 0.05) / (color.luminance + 0.05)
    return if (ratio < 1.0) 1.0 / ratio else ratio
}

private fun Color.adjustByAdding(saturation: Float = 0f, luminance: Float = 0f): Color {
    val hsl = FloatArray(3)
    ColorUtils.colorToHSL(this.toArgb(), hsl)
    val finalHsl = FloatArray(3)
    finalHsl[0] = hsl[0]
    finalHsl[1] = 1f.coerceAtMost(0f.coerceAtLeast(hsl[1] + saturation))
    finalHsl[2] = 1f.coerceAtMost(0f.coerceAtLeast(hsl[2] + luminance))
    return Color(ColorUtils.HSLToColor(finalHsl))
}



