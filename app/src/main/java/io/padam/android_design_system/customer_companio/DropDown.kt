package io.padam.android_design_system.customer_companio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.padam.android_ui.customer.atoms.controls.PUIDropdown
import io.padam.android_ui.customer.atoms.controls.PUIDropdownSelectable

data class WeekDay(override val description: String): PUIDropdownSelectable {
    companion object {
        val Monday = WeekDay("Monday")
        val Tuesday = WeekDay("Tuesday")
        val Wednesday = WeekDay("Wednesday")
        val Thursday = WeekDay("Thursday")
        val Friday = WeekDay("Friday")
        val Saturday = WeekDay("Saturday")
        val Sunday = WeekDay("Sunday")

        val allCases: List<WeekDay> = listOf(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
    }
}

@Composable
fun DropDown() {
    val selectedDay: MutableState<WeekDay?> = remember { mutableStateOf(null) }
    PUIDropdown(
        placeholder = "Choose a week day :",
        values = WeekDay.allCases,
        selected = selectedDay
    )
}

