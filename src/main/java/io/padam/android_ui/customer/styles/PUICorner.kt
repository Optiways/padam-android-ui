package io.padam.android_ui.customer.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class PUICorner(val radius: Dp) {

    Soft(radius = 10.dp),
    Medium(radius = 20.dp),
    Heavy(radius = 30.dp)

}

fun Modifier.setCorner(corner: PUICorner?) : Modifier = then(
    clip(RoundedCornerShape(corner?.radius ?: 0.dp))
)