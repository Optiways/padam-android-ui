package io.padam.android_ui.customer.atoms.controls

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.styles.PUILabelGray
import io.padam.android_ui.customer.styles.PUIPrimaryDark
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUITextStyle

@Composable
fun PUICheckbox(
    isOn: MutableState<Boolean>,
    text: String
) {
    val isPressed = remember { mutableStateOf(false) }
    PUIControl(
        action = { isOn.value = !isOn.value },
        isPressed = isPressed
    ) {
        PUILabel(
            id = if (isOn.value) R.drawable.checkmark_square_fill else R.drawable.square,
            imageSize = 20.dp,
            spacing = PUISpace2,
            text = text,
            style = PUITextStyle.Footnote,
            tintColor = Color.PUIPrimaryDark,
            textColor = Color.PUILabelGray,
            textModifier = Modifier.controlPressedAppearance(isPressed)
        )
    }
}