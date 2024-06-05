package io.padam.android_ui.customer

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.padam.android_ui.customer.styles.PUIPrimary

class PadamUI {

    companion object {

        var defaultPrimaryColor = Color(0xFF1D1A3F)

        fun setup(primaryColor: Color) {
            this.defaultPrimaryColor = primaryColor
        }
    }
}


@Composable
fun GreetingPreview() {
    Box {
        Color.PUIPrimary
    }
}