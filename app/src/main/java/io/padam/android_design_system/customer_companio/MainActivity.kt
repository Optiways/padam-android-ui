package io.padam.android_design_system.customer_companio

import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.padam.android_design_system.customer_companio.ui.theme.CustomerCompanionTheme
import io.padam.android_ui.customer.PadamUI
import io.padam.android_ui.customer.styles.PUIAppearance
import io.padam.android_ui.customer.styles.PUILabelBlue
import io.padam.android_ui.customer.atoms.controls.PUIButton
import io.padam.android_ui.customer.styles.PUISpace3
import io.padam.android_ui.customer.R

import io.padam.android_ui.customer.atoms.PUIEmailField
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.atoms.controls.PUIActionItem
import io.padam.android_ui.customer.atoms.PUIPanelError
import io.padam.android_ui.customer.atoms.PUIPanelInformation
import io.padam.android_ui.customer.atoms.PUIPanelSuccess
import io.padam.android_ui.customer.atoms.PUIPanelWarning
import io.padam.android_ui.customer.atoms.PUISecureField
import io.padam.android_ui.customer.atoms.PUITextField
import io.padam.android_ui.customer.atoms.PUITextFieldItemConfiguration
import io.padam.android_ui.customer.atoms.controls.PUICheckbox
import io.padam.android_ui.customer.atoms.controls.PUIDropdown
import io.padam.android_ui.customer.atoms.controls.PUIDropdownSelectable
import io.padam.android_ui.customer.atoms.controls.PUILink
import io.padam.android_ui.customer.atoms.controls.PUILinkInApp
import io.padam.android_ui.customer.atoms.controls.PUILinkWeb
import io.padam.android_ui.customer.models.PUIAlert
import io.padam.android_ui.customer.styles.PUIBackgroundGreen
import io.padam.android_ui.customer.styles.PUIBorder
import io.padam.android_ui.customer.styles.PUICorner
import io.padam.android_ui.customer.styles.PUIElevation
import io.padam.android_ui.customer.styles.PUIForeground
import io.padam.android_ui.customer.styles.PUILabelGray
import io.padam.android_ui.customer.styles.PUILabelGreen
import io.padam.android_ui.customer.styles.PUILabelRed
import io.padam.android_ui.customer.styles.PUIPrimary
import io.padam.android_ui.customer.styles.PUIPrimaryDark
import io.padam.android_ui.customer.styles.PUIPrimaryLight
import io.padam.android_ui.customer.styles.PUISpace1
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUITextStyle
import io.padam.android_ui.customer.styles.contrastedShadeColor
import io.padam.android_ui.customer.styles.setBorder


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isOn = mutableStateOf(false)
        enableEdgeToEdge()

        val masterChiefColor = Color(0xff3F4E2A)
        PadamUI.setup(masterChiefColor)

        setContent {
            Column(
                verticalArrangement = Arrangement.spacedBy(PUISpace2),
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())

            ) {

                TextFields()
//                PadamUIElementTitle(text = "TextField")
//
//
//
//                var error: MutableState<PUIAlert?> = remember {
//                    mutableStateOf(PUIAlert.Error(message = "Error errror erroor"))
//                }
//
//
//                val email = remember { mutableStateOf("") }
//                val password = remember { mutableStateOf("") }
//                val firstName = remember { mutableStateOf("Kiefer") }
//
//                Column(
//                    modifier = Modifier.padding(20.dp),
//                    verticalArrangement = Arrangement.spacedBy(PUISpace3)
//                ) {
//
//                    PUIEmailField(
//                        placeholder = "E-mail",
//                        text = email,
//                        alert = error
//                    )
//
//                    PUISecureField(
//                        placeholder = "Password",
//                        text = password
//                    )
//
//                    PUITextField(
//                        id = R.drawable.person_fill,
//                        placeholder = "Firstname",
//                        text = firstName,
//                        leadingItem = PUITextFieldItemConfiguration(id = R.drawable.arrow_up_right_square) {
//                            Log.d("toto", "show country codses")
//                        }
//                    )
//
//                }
//
//
//
//
//
//                PadamUIElementTitle(text = "Dropdown")
//
//                //@State var selectedDay: WeekDay?
//                val selectedDay = remember { mutableStateOf<WeekDay?>(null) }
//
//                PUIDropdown(placeholder = "Select a day", values = WeekDay.allCases, selected = selectedDay)
//
//                PadamUIElementTitle(text = "Theme")
//
//                Row(
//                    modifier = Modifier
//                        .padding(vertical = 40.dp)
//                        .fillMaxWidth()
//                    ,
//                    horizontalArrangement = Arrangement.spacedBy(PUISpace3, alignment = Alignment.CenterHorizontally)
//
//                ) {
//                    ColorDisk(name = "Primary", color = Color.PUIPrimary)
//                    ColorDisk(name = "Light", color = Color.PUIPrimaryLight)
//                    ColorDisk(name = "Dark", color = Color.PUIPrimaryDark)
//                }
//
//
//                // - Labels
//
//                PadamUIElementTitle(text = "Labels")
//
//                val labelImage = R.drawable.checkmark_circle
//                PUILabel(id = labelImage, text = "Large Title", style = PUITextStyle.LargeTitle)
//                PUILabel(id = labelImage, text = "Title 1", style = PUITextStyle.Title1)
//                PUILabel(id = labelImage, text = "title 2", style = PUITextStyle.Title2)
//                PUILabel(id = labelImage, text = "Title 3", style = PUITextStyle.Title3)
//                PUILabel(id = labelImage, text = "Headline", style = PUITextStyle.Headline)
//                PUILabel(id = labelImage, text = "Body", style = PUITextStyle.Body)
//                PUILabel(id = labelImage, text = "Sub Headline", style = PUITextStyle.SubHeadline)
//                PUILabel(id = labelImage, text = "Footnote", style = PUITextStyle.Footnote)
//                PUILabel(id = labelImage, text = "Caption 1", style = PUITextStyle.Caption1)
//                PUILabel(id = labelImage, text = "Caption 2", style = PUITextStyle.Caption2)
//
//
//
//                // - Panels
//                PadamUIElementTitle(text = "Panels")
//                PUIPanelError(text = "Error Error Error Error Error Error Error Error Error Error Error.")
//                PUIPanelSuccess(text = "Success Success Success Success Success Success Success Success.")
//                PUIPanelWarning(text = "Warning Warning Warning Warning Warning Warning Warning Warning.")
//                PUIPanelInformation(text = "Info Info Info Info Info Info Info Info Info Info Info Info.")
//
//
//                // - Checkbox
//                PadamUIElementTitle(text = "Checkbox")
//                PUICheckbox(isOn = isOn, text = "Text ".repeat(30))
//
//
//                // - Buttons
//
//                val buttonImage = R.drawable.person_fill
//                PadamUIElementTitle(text = "Buttons")
//                PUIButton(
//                    id = buttonImage,
//                    title = "Filled Primary",
//                    action = {},
//                    appearance = PUIAppearance.filledPrimary(),
//                    isEnabled = false
//                )
//
//
//                PUIButton(id = buttonImage, title = "Filled Primary Light", action = {}, appearance = PUIAppearance.filledPrimaryLight())
//                PUIButton(id = buttonImage, title = "Outline", action = {}, appearance = PUIAppearance.plumpyBorder())
//                PUIButton(id = buttonImage, title = "Outline Red", action = {}, appearance = PUIAppearance.plumpyBorder(Color.PUILabelRed), isEnabled = false)
//                PUIButton(id = buttonImage, title = "Elevated", action = {}, appearance = PUIAppearance.elevated(PUIElevation.Prominent))
//                PUIButton(id = buttonImage, title = "Plain", action = {}, appearance = PUIAppearance.plain(Color.PUILabelBlue))
//
//
//
//                // - Action Items
//
//                val actionItemImage = R.drawable.info_circle
//                PadamUIElementTitle(text = "Action Items")
//                PUIActionItem(id = actionItemImage, action = {}, appearance = PUIAppearance.filledPrimary())
//                PUIActionItem(id = actionItemImage, action = {}, appearance = PUIAppearance.elevated(PUIElevation.Prominent, tintColor = Color.PUILabelBlue))
//                PUIActionItem(id = actionItemImage, action = {}, appearance = PUIAppearance.slightBorder())
//
//
//
//                // - Links
//
//                PadamUIElementTitle(text = "Links")
//                PUILinkWeb(text = "Web link Web link Web link ", action = {})
//                PUILinkInApp(text = "In App Link In App Link In App Link ", action = {})
//
//                PUILink(text = "Hello World", isWebLink = false) {
//                    Log.i("PadamKit", "Hello World")
//                }
//
//
//
//
//
//
//
//


            }
        }
    }


}

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
fun PadamUIElementTitle(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.spacedBy(PUISpace1, alignment = Alignment.CenterHorizontally)

    ) {
        PUILabel(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .setBorder(PUIBorder.Plumpy(Color.PUIPrimaryLight), PUICorner.Soft.radius)
                .padding(horizontal = PUISpace2, vertical = PUISpace1)
            ,
            text = text,
            style = PUITextStyle.Title3,
            textColor = Color.PUIPrimaryLight
        )
    }
}


@Composable
fun ColorDisk(name: String, color: Color) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .size(80.dp)
            .background(color)
    ) {
        PUILabel(text = name, textColor = color.contrastedShadeColor, style = PUITextStyle.Headline)
    }
}

@Composable
@Preview
fun MainPreview(){
    Text(text = "Hello label")
}












