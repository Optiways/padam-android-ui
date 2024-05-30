package io.padam.android_ui.customer.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.padam.android_ui.customer.styles.Epilogue
import io.padam.android_ui.customer.styles.PUILabel
import io.padam.android_ui.customer.styles.PUIPrimary
import io.padam.android_ui.customer.styles.PUISpace1
import io.padam.android_ui.customer.styles.PUITextStyle
import kotlin.math.max

@Composable
fun PUILabel(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int? = null,
    text: String,
    style: PUITextStyle = PUITextStyle.Body,
    tintColor: Color = Color.PUIPrimary,
    textColor: Color = Color.PUILabel
) {
    PUILabel(id = id,
        modifier = modifier,
        imageSize = style.fontSize.dp,
        spacing = PUISpace1,
        text = text,
        style = style,
        tintColor = tintColor,
        textColor = textColor)
}


@Composable
internal fun PUILabel(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int?,
    imageSize: Dp,
    spacing: Dp,
    text: String,
    style: PUITextStyle,
    tintColor: Color,
    textColor: Color,
    textModifier: Modifier = Modifier,
    isUnderlined: Boolean = false,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        var maxBaseline by remember { mutableFloatStateOf(0f) }
        fun updateMaxBaseline(textLayoutResult: TextLayoutResult) {
            maxBaseline = max(maxBaseline, textLayoutResult.size.height - textLayoutResult.lastBaseline)
        }
        val topBaselinePadding = with(LocalDensity.current) { maxBaseline.toDp() }
        id?.let {
            Image(
                modifier = Modifier
                    .padding(top = if (style.fontFamily == Epilogue) 0.dp else topBaselinePadding / 2 )
                    .size(size = imageSize)
                ,
                painter = painterResource(id = it),
                colorFilter = ColorFilter.tint(tintColor),
                contentDescription = null
            )
        }
        BasicText(
            modifier = Modifier
                .padding(top = if (style.fontFamily == Epilogue) topBaselinePadding / 2 else 1.dp )
                .then(textModifier)
            ,
            text = text,
            style = TextStyle(
                fontFamily = style.fontFamily,
                fontWeight = style.fontWeight,
                fontSize = style.fontSize.sp,
                color = textColor,
                textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None
            ),
            onTextLayout = ::updateMaxBaseline
        )
    }
}