package io.padam.android_ui.customer.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUICorner
import io.padam.android_ui.customer.styles.PUISpace1
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUITextStyle
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.styles.setCorner

@Composable
fun PUIPanel(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int?,
    text: String,
    appearance: PUIAppearance
) {
    Box(
        modifier = Modifier
            .setCorner(PUICorner.Soft)
            .background(appearance.backgroundColor)
            .padding(PUISpace2)
            .fillMaxWidth()
            .then(modifier),
    ) {
        PUILabel(
            id = id,
            imageSize = 20.dp,
            spacing = PUISpace1,
            text = text,
            style = PUITextStyle.Body,
            tintColor = appearance.tintColor,
            textColor = appearance.textColor
        )
    }
}

@Composable
fun PUIPanelInformation(
    modifier: Modifier = Modifier,
    text: String
) {
    PUIPanel(
        modifier = modifier,
        id = R.drawable.info_circle,
        text = text,
        appearance = PUIAppearance.filledInformation()
    )
}

@Composable
fun PUIPanelError(
    modifier: Modifier = Modifier,
    text: String
) {
    PUIPanel(
        modifier = modifier,
        id = R.drawable.exclamationmark_circle,
        text = text,
        appearance = PUIAppearance.filledError()
    )
}

@Composable
fun PUIPanelSuccess(
    modifier: Modifier = Modifier,
    text: String
) {
    PUIPanel(
        modifier = modifier,
        id = R.drawable.checkmark_circle,
        text = text,
        appearance = PUIAppearance.filledSuccess()
    )
}

@Composable
fun PUIPanelWarning(
    modifier: Modifier = Modifier,
    text: String
) {
    PUIPanel(
        modifier = modifier,
        id = R.drawable.exclamationmark_triangle,
        text = text,
        appearance = PUIAppearance.filledWarning()
    )
}

