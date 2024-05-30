package io.padam.android_ui.customer.styles

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

 open class PUIBorder(open val color: Color, val borderWidth: Dp) {

     open class Slight(override val color: Color): PUIBorder(color, 1.dp)

     class Skimpy(): Slight(Color.PUIGray1)

     class Plumpy(override val color: Color): PUIBorder(color, 2.dp)

     internal fun copy(withColor: Color = this.color, withBorderWidth: Dp = this.borderWidth): PUIBorder {
         return PUIBorder(color, this.borderWidth)
     }
}

fun Modifier.setBorder(border: PUIBorder?, corner: Dp = 0.dp): Modifier {
    border?.let {
        return this.border(
            color = border.color ?: Color.Transparent,
            width = border.borderWidth ?: 0.dp,
            shape = RoundedCornerShape(corner)
        )
    }
    return this.clip(RoundedCornerShape(corner))
}