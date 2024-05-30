package io.padam.android_ui.customer.atoms.controls

import android.credentials.Credential
import android.util.Log
import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.atoms.PUILabel
import io.padam.android_ui.customer.atoms.PUITextField
import io.padam.android_ui.customer.styles.PUIBackground
import io.padam.android_ui.customer.styles.PUIBackgroundGray
import io.padam.android_ui.customer.styles.PUIBorder
import io.padam.android_ui.customer.styles.PUICorner
import io.padam.android_ui.customer.styles.PUIElevation
import io.padam.android_ui.customer.styles.PUIForeground
import io.padam.android_ui.customer.styles.PUIGray1
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUISpace4
import io.padam.android_ui.customer.styles.PUITextStyle
import io.padam.android_ui.customer.styles.setBorder
import io.padam.android_ui.customer.styles.setElevation
import kotlin.math.max
import kotlin.math.min

interface PUIDropdownSelectable {
    val description: String
}

@Composable
fun <Value: PUIDropdownSelectable> PUIDropdown(placeholder: String, values: List<Value>, selected: MutableState<Value?>) {

    val isOpen = remember { mutableStateOf(false) }
    val isPressed = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val maxDisplayedItem: Int = 4
    val closedHeight: Dp = 50.dp
    val itemHeight: Dp = 40.dp

    fun contentHeight(): Dp {
       return max(maxDisplayedItem, values.count() * 40).dp
    }

    fun onSelect(value: Value?) {
        selected.value = value
        isOpen.value = false
    }


    @Composable
    fun PlaceHolder() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .controlPressedAppearance(isPressed)
                .height(closedHeight)
                .background(Color.PUIBackgroundGray)
                .padding(horizontal = PUISpace4)
                .fillMaxWidth()

        ) {
            PUILabel(
                text = selected.value?.description ?: placeholder
            )
            Image(
                painter = painterResource(id = R.drawable.chevron_down),
                modifier = Modifier.size(20.dp),
                contentDescription = "")
        }
    }


    @Composable fun ItemRow(value: Value) {
        val rowIsPressed = remember { mutableStateOf(false) }
        PUIControl(
            action = { onSelect(value) },
            isPressed = rowIsPressed
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .controlPressedAppearance(rowIsPressed)
                    .background(if (value == selected.value) Color.PUIGray1 else Color.PUIBackground)
                    .height(itemHeight)
                    .fillMaxWidth()
                    .padding(horizontal = PUISpace2)

            ) {
                PUILabel(
                    text = value.description,
                    style = PUITextStyle.SubHeadline

                )
            }
        }
    }
    Box {
        PUIControl(
            modifier = Modifier
                .setBorder(if (isOpen.value) PUIBorder.Skimpy() else null, closedHeight / 2)
                .fillMaxWidth()
                .background(Color.PUIForeground)
                .animateContentSize()
            ,
            action = { isOpen.value = !isOpen.value },
            isActive = !isOpen.value,
            isPressed = isPressed
        ) {
            Column {
                PlaceHolder()
                if (isOpen.value) {
                    Column(
                        modifier = Modifier
                            .height(contentHeight())
                            .verticalScroll(scrollState)
                    ) {
                        values.onEach {
                            ItemRow(value = it)
                        }
                    }
                }
            }
        }
    }

}
