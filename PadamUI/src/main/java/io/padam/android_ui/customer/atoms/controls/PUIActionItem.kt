package io.padam.android_ui.customer.atoms.controls

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.setBorder
import io.padam.android_ui.customer.styles.setElevation

@Composable
fun PUIActionItem(
    @DrawableRes id: Int,
    action: () -> Unit,
    appearance: PUIAppearance
) {
    val size = 50.dp
    val isPressed = remember { mutableStateOf(false) }
    PUIControl(
        modifier = Modifier
            .controlPressedAppearance(isPressed)
            .setElevation(appearance.elevation)
            .size(size)
            .setBorder(appearance.border, size / 2)
            .background(appearance.backgroundColor)
        ,
        action = action,
        isPressed = isPressed
    ) {
        Image(
            modifier = Modifier.size(size / 2),
            painter = painterResource(id = id),
            contentDescription = "",
            colorFilter = ColorFilter.tint(appearance.tintColor)
        )
    }
}
