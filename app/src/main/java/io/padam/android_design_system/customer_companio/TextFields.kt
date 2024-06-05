package io.padam.android_design_system.customer_companio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import io.padam.android_ui.customer.atoms.PUIEmailField
import io.padam.android_ui.customer.atoms.PUISecureField
import io.padam.android_ui.customer.atoms.controls.PUIActionItem
import io.padam.android_ui.customer.models.PUIAlert
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUISpace3
import io.padam.android_ui.customer.styles.PUISpace4
import io.padam.android_ui.customer.styles.PUISpace5


@Preview
@Composable
fun TextFields() {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val alert: MutableState<PUIAlert?> = remember { mutableStateOf(null) }

    Column(
        verticalArrangement = Arrangement.spacedBy(PUISpace4),
        modifier = Modifier.padding(horizontal = PUISpace4, vertical = PUISpace5)
    ) {

        PUISecureField(placeholder = "Password", text = password, alert = alert)

        PUIEmailField(placeholder = "Email", text = email, alert = alert)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val errorAlert = PUIAlert.Error(message = "This in an ERROR message.")
            val warningAlert = PUIAlert.Warning(message = "This in an WARNING message.")
            val successAlert = PUIAlert.Success(message = "This in an SUCCESS message.")
            val informationAlert = PUIAlert.Information(message = "This in an INFORMATION message.")
            val neutralAlert = PUIAlert.Neutral(message = "This in an NEUTRAL message.")

            PUIActionItem(
                id = io.padam.android_ui.customer.R.drawable.exclamationmark_circle,
                action = { alert.value =  errorAlert },
                appearance = errorAlert.appearance
            )
            PUIActionItem(
                id = io.padam.android_ui.customer.R.drawable.exclamationmark_triangle,
                action = { alert.value = warningAlert },
                appearance = warningAlert.appearance
            )
            PUIActionItem(
                id = io.padam.android_ui.customer.R.drawable.checkmark_circle,
                action = { alert.value =  successAlert},
                appearance = successAlert.appearance
            )
            PUIActionItem(
                id = io.padam.android_ui.customer.R.drawable.info_circle,
                action = { alert.value =  informationAlert },
                appearance = informationAlert.appearance
            )
            PUIActionItem(
                id = io.padam.android_ui.customer.R.drawable.info_circle,
                action = { alert.value = neutralAlert },
                appearance = neutralAlert.appearance
            )
        }
    }


}

