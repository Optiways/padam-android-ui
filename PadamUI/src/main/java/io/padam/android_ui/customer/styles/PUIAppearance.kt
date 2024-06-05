package io.padam.android_ui.customer.styles

import androidx.compose.ui.graphics.Color


class PUIAppearance(
    val backgroundColor: Color,
    val tintColor: Color,
    val textColor: Color,
    val elevation: PUIElevation? = null,
    val border: PUIBorder? = null,
    val disabledAppearance: PUIAppearance? = null
) {

    companion object {

        fun filled(color: Color, foregroundColor: Color = color.contrastedShadeColor): PUIAppearance {
            return PUIAppearance(backgroundColor = color, tintColor = foregroundColor, textColor = foregroundColor, disabledAppearance = filledDisabled)
        }

        private val filledDisabled: PUIAppearance
            get() = PUIAppearance(
                backgroundColor = Color.PUIGray2,
                tintColor = Color.PUIGray1.contrastedShadeColor,
                textColor = Color.PUIGray1.contrastedShadeColor
            )


        fun filledPrimary(): PUIAppearance {
            return filled(Color.PUIPrimary)
        }

        fun filledPrimaryLight(): PUIAppearance {
            return filled(Color.PUIPrimaryLight)
        }

        fun filledPrimaryDark(): PUIAppearance {
            return filled(Color.PUIPrimaryDark)
        }

        fun filledWarning(): PUIAppearance {
            return filled(Color.PUIBackgroundYellow, foregroundColor = Color.PUILabelYellow)
        }

        fun filledError(): PUIAppearance {
            return filled(Color.PUIBackgroundRed, foregroundColor = Color.PUILabelRed)
        }

        fun filledSuccess(): PUIAppearance {
            return filled(Color.PUIBackgroundGreen, foregroundColor = Color.PUILabelGreen)
        }

        fun filledInformation(): PUIAppearance {
            return filled(Color.PUIBackgroundBlue, foregroundColor = Color.PUILabelBlue)
        }

        fun filledNeutral(): PUIAppearance {
            return filled(Color.PUIBackgroundGray, foregroundColor = Color.PUILabelGray)
        }


        // - Outline

        internal fun outlineDisabled(border: PUIBorder): PUIAppearance {
            return PUIAppearance(
                backgroundColor = Color.Transparent,
                textColor = Color.PUIGray2,
                tintColor = Color.PUIGray2,
                border = border.copy(withColor = Color.PUIGray2)
            )
        }


        fun outline(border: PUIBorder): PUIAppearance {
            return PUIAppearance(
                backgroundColor = Color.Transparent,
                tintColor = border.color,
                textColor = border.color,
                border = border,
                disabledAppearance = outlineDisabled(border)
            )
        }

        fun slightBorder(color: Color = Color.PUILabel): PUIAppearance {
            return PUIAppearance.outline(PUIBorder.Slight(color))
        }

        fun plumpyBorder(color: Color = Color.PUILabel): PUIAppearance {
            return PUIAppearance.outline(PUIBorder.Plumpy(color))
        }

        fun elevated(elevation: PUIElevation, tintColor: Color = Color.PUIPrimary, textColor: Color = Color.PUILabel): PUIAppearance {
            return PUIAppearance(backgroundColor = Color.PUIForeground, tintColor = tintColor, textColor = textColor, elevation = elevation)
        }

        fun plain(color: Color): PUIAppearance {
            return PUIAppearance(backgroundColor = Color.Transparent, tintColor = color, textColor = color)
        }
    }

}