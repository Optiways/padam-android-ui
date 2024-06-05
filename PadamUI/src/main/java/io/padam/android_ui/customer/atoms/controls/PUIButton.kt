package io.padam.android_ui.customer.atoms.controls

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUIBorder
import io.padam.android_ui.customer.styles.PUIElevation
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUISpace3
import io.padam.android_ui.customer.styles.PUISpace4
import io.padam.android_ui.customer.styles.PUITextStyle
import io.padam.android_ui.customer.styles.setBorder
import io.padam.android_ui.customer.styles.setElevation


@Composable
fun PUIButton(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int?,
    title: String,
    action: () -> Unit,
    isEnabled: Boolean = true,
    appearance: PUIAppearance
) {
    val height = 50.dp
    val isPressed = remember { mutableStateOf(false) }

    fun elevation(): PUIElevation? {
        return if (isEnabled) appearance.elevation else appearance.disabledAppearance?.elevation
    }

    fun border(): PUIBorder? {
        return if (isEnabled) appearance.border else appearance.disabledAppearance?.border
    }

    fun background(): Color {
        val disabledColor = appearance.disabledAppearance?.backgroundColor ?: appearance.backgroundColor
        return if (isEnabled) appearance.backgroundColor else disabledColor
    }

    PUIControl(
        modifier = Modifier
            .controlPressedAppearance(isPressed)
            .setElevation(elevation())
            .setBorder(border(), corner = height / 2)
            .background(background())
            .padding(horizontal = PUISpace4, vertical = PUISpace3)
            .then(modifier)
        ,
        action = action,
        isPressed = isPressed,
        isActive = isEnabled,
    ) {
        PUILabel(
            id = id,
            imageSize = PUITextStyle.Headline.fontSize.dp,
            spacing = PUISpace2,
            text = title,
            style = PUITextStyle.Headline,
            tintColor = appearance.tintColor,
            textColor = appearance.textColor
        )
    }
}

