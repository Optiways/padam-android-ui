package io.padam.android_ui.customer.atoms

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.atoms.controls.PUIControl
import io.padam.android_ui.customer.atoms.controls.controlPressedAppearance
import io.padam.android_ui.customer.styles.PUIGray1
import io.padam.android_ui.customer.styles.PUISpace1
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUITextStyle

data class PUITextFieldItemConfiguration(@DrawableRes val id: Int, val action: () -> Unit)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PUITextField(
    @DrawableRes id: Int? = null,
    modifier: Modifier = Modifier,
    placeholder: String,
    text: MutableState<String>,
    isSecure: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    leadingItem: PUITextFieldItemConfiguration? = null
) {

    // - States - //

    val interactionSource = remember { MutableInteractionSource() }
    val secureState = remember { mutableStateOf(isSecure) }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isEdited = text.value.isNotEmpty()

    // - Text Utils - //

    val textStyle = PUITextStyle.Body
    val textHeight: Dp = textStyle.fontSize.dp

    // - Data Modifiers

    fun clearText() { text.value = "" }

    fun updateText(value: String) { text.value = value }

    fun toggleSecure() { secureState.value = !secureState.value }



    @Composable
    fun Placeholder() {
        val isUp = isFocused || isEdited
        val style = if (isUp) PUITextStyle.Caption1 else PUITextStyle.SubHeadline
        val paddingBottom = if (isUp) textHeight else 0.dp
        PUILabel(
            modifier = Modifier
                .padding(vertical = PUISpace1)
                .padding(bottom = paddingBottom)
            ,
            id = id,
            text = placeholder,
            style = style
        )
    }

    @Composable
    fun Field() {
        if (secureState.value) {
            BasicSecureTextField(
                value = text.value,
                onValueChange = ::updateText,
                modifier = Modifier.height(textHeight),
                textStyle = textStyle.toSystemTextStyle(),
                interactionSource = interactionSource
            )
        } else {
            BasicTextField(
                value = text.value,
                onValueChange = ::updateText,
                modifier = Modifier.height(textHeight),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                textStyle = textStyle.toSystemTextStyle(),
                maxLines = 1,
                interactionSource = interactionSource
            )
        }

    }


    @Composable
    fun Item(@DrawableRes id: Int, action: () -> Unit) {
        val isPressed = remember { mutableStateOf(false) }
        PUIControl(
            action = action,
            isPressed = isPressed,
            modifier = Modifier
                .size(width = 30.dp, height = 20.dp)
                .controlPressedAppearance(isPressed)
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.PUIGray1)
            )
        }
    }


    Column(
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = modifier.animateContentSize().background(Color.Red),
            contentAlignment = Alignment.BottomStart,
        ) {
            Placeholder()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                leadingItem?.let {
                    Item(id = it.id, action = it.action)
                }
                Field()
                if (isEdited) {
                    Item(R.drawable.xmark_circle_fill, action = ::clearText)
                }
                if (isSecure && isEdited) {
                    if (secureState.value) {
                        Item(R.drawable.eye, action = ::toggleSecure)
                    } else {
                        Item(R.drawable.eye_slash, action = ::toggleSecure)
                    }
                }

            }

        }
        Box(modifier = Modifier
            .padding(vertical = PUISpace2)
            .fillMaxWidth()
            .background(Color.PUIGray1)
            .height(1.dp)

        )
    }





}