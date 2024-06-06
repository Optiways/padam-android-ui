package io.padam.android_design_system.customer_companio

import androidx.compose.runtime.Composable
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.styles.PUITextStyle

@Composable
fun Labels() {

    val labelImage = io.padam.android_ui.customer.R.drawable.person_fill

    PUILabel(id = labelImage, text = "Large Title", style = PUITextStyle.LargeTitle)
    PUILabel(id = labelImage, text = "Title 1", style = PUITextStyle.Title1)
    PUILabel(id = labelImage, text = "title 2", style = PUITextStyle.Title2)
    PUILabel(id = labelImage, text = "Title 3", style = PUITextStyle.Title3)
    PUILabel(id = labelImage, text = "Headline", style = PUITextStyle.Headline)
    PUILabel(id = labelImage, text = "Body", style = PUITextStyle.Body)
    PUILabel(id = labelImage, text = "Sub Headline", style = PUITextStyle.SubHeadline)
    PUILabel(id = labelImage, text = "Footnote", style = PUITextStyle.Footnote)
    PUILabel(id = labelImage, text = "Caption 1", style = PUITextStyle.Caption1)
    PUILabel(id = labelImage, text = "Caption 2", style = PUITextStyle.Caption2)

}