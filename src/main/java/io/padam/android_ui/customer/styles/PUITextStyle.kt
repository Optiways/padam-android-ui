package io.padam.android_ui.customer.styles


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.padam.android_ui.customer.R


internal val DMSans: FontFamily = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal)
)

internal val Epilogue = FontFamily(
    Font(R.font.epilogue_bold, FontWeight.Bold)
)

enum class PUITextStyle(val fontFamily: FontFamily, val fontWeight: FontWeight, val fontSize: Int) {

    LargeTitle(
        fontFamily = Epilogue,
        fontWeight = FontWeight.Bold,
        fontSize = 34
    ),
    Title1(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 28
    ),
    Title2(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 22
    ),
    Title3(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20
    ),
    Headline(
        fontFamily = Epilogue,
        fontWeight = FontWeight.Bold,
        fontSize = 17
    ),
    Body(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17
    ),
    Callout(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16
    ),
    SubHeadline(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15
    ),
    Footnote(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13
    ),
    Caption1(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12
    ),
    Caption2(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 11
    );

    fun toSystemTextStyle(): TextStyle {
        return TextStyle(
            fontFamily = this.fontFamily,
            fontSize = this.fontSize.sp,
            fontWeight = this.fontWeight
        )
    }


}