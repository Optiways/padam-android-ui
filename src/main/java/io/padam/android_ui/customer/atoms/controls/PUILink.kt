package io.padam.android_ui.customer.atoms.controls

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUILabelBlue
import io.padam.android_ui.customer.styles.PUILabelGray
import io.padam.android_ui.customer.styles.PUISpace1
import io.padam.android_ui.customer.styles.PUITextStyle

@Composable
fun PUILink(
    text: String,
    isWebLink: Boolean,
    action: () -> Unit
) {
    val style = PUITextStyle.Caption1
    val color = if (isWebLink) Color.PUILabelBlue else Color.PUILabelGray
    val isPressed = remember {
        mutableStateOf(false)
    }
    PUIControl(
        action = action,
        isPressed = isPressed,
        modifier = Modifier.controlPressedAppearance(isPressed)
    ) {
        PUILabel(
            id = R.drawable.arrow_up_right_square,
            imageSize = style.fontSize.dp,
            spacing = PUISpace1,
            text = text,
            style = style,
            tintColor = color,
            textColor = color,
            isUnderlined = true
        )
    }
}

@Composable
fun PUILinkWeb(text: String, action: () -> Unit) {
    return PUILink(text = text, isWebLink = true, action = action)
}

@Composable
fun PUILinkInApp(text: String, action: () -> Unit) {
    return PUILink(text = text, isWebLink = false, action = action)
}