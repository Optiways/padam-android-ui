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
import io.padam.android_ui.customer.styles.PUISpace4
import io.padam.android_ui.customer.styles.PUISpace5
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
                verticalArrangement = Arrangement.spacedBy(PUISpace4),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = PUISpace5, horizontal = PUISpace3)
                    .verticalScroll(rememberScrollState())

            ) {

                Labels()
                TextFields()
                DropDown()
            }
        }
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












