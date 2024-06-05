package io.padam.android_ui.customer.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUIBackgroundBlue
import io.padam.android_ui.customer.styles.PUIBackgroundGreen
import io.padam.android_ui.customer.styles.PUIBackgroundRed
import io.padam.android_ui.customer.styles.PUIBackgroundYellow
import io.padam.android_ui.customer.styles.PUILabelBlue
import io.padam.android_ui.customer.styles.PUILabelGreen
import io.padam.android_ui.customer.styles.PUILabelRed
import io.padam.android_ui.customer.styles.PUILabelYellow

sealed class PUIAlert(
    open val title: String?,
    open val message: String,
    val appearance: PUIAppearance,
    @DrawableRes val id: Int
) {

    class Information(
        override val title: String? = null,
        override val message: String
    ) : PUIAlert(
        title, message,
        PUIAppearance.filledInformation(),
        R.drawable.info_circle
    )

    class Error(
        override val title: String? = null,
        override val message: String
    ) : PUIAlert(
        title,
        message,
        PUIAppearance.filledError(),
        R.drawable.exclamationmark_circle
    )

    class Warning(
        override val title: String? = null,
        override val message: String
    ) : PUIAlert(
        title,
        message,
        PUIAppearance.filledWarning(),
        R.drawable.exclamationmark_triangle
    )

    class Success(
        override val title: String? = null,
        override val message: String
    ) : PUIAlert(
        title,
        message,
        PUIAppearance.filledSuccess(),
        R.drawable.checkmark_circle
    )

    class Neutral(
        override val title: String? = null,
        override val message: String
    ) : PUIAlert(
        title,
        message,
        PUIAppearance.filledNeutral(),
        R.drawable.exclamationmark_circle
    )
}