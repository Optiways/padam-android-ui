package io.padam.android_ui.customer.atoms

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.padam.android_ui.customer.R
import io.padam.android_ui.customer.atoms.controls.PUIControl
import io.padam.android_ui.customer.atoms.controls.controlPressedAppearance
import io.padam.android_ui.customer.models.PUIAlert
import io.padam.android_ui.customer.styles.PUIBackgroundBlue
import io.padam.android_ui.customer.styles.PUIBackgroundGreen
import io.padam.android_ui.customer.styles.PUIBackgroundRed
import io.padam.android_ui.customer.styles.PUIBackgroundYellow
import io.padam.android_ui.customer.styles.PUIGray1
import io.padam.android_ui.customer.styles.PUILabel
import io.padam.android_ui.customer.styles.PUILabelBlue
import io.padam.android_ui.customer.styles.PUILabelGray
import io.padam.android_ui.customer.styles.PUILabelGreen
import io.padam.android_ui.customer.styles.PUILabelRed
import io.padam.android_ui.customer.styles.PUILabelYellow
import io.padam.android_ui.customer.styles.PUISpace2
import io.padam.android_ui.customer.styles.PUITextStyle


data class PUITextFieldConfiguration(@DrawableRes private val id: Int?, private val content: (@Composable () -> Unit)?, val action: () -> Unit) {

    constructor(@DrawableRes id: Int, action: () -> Unit): this(id = id, content = null, action = action)

    constructor(content: @Composable () -> Unit, action: () -> Unit): this(id = null, content = content, action = action)

}

data class PUITextFieldItemConfiguration(@DrawableRes val id: Int, val action: () -> Unit)


@Composable
fun PUITextField(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int? = null,
    placeholder: String,
    text: MutableState<String>,
    isSecure: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    leadingItem: PUITextFieldItemConfiguration? = null,
    alert: MutableState<PUIAlert?> = mutableStateOf(null)
) {

    // - States - //

    val interactionSource = remember { MutableInteractionSource() }
    val secureState = remember { mutableStateOf(isSecure) }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isEdited = text.value.isNotEmpty()
    val isPlaceholderCollapsed: Boolean = isEdited || isFocused


    // - Text Utils - //

    val textStyle = PUITextStyle.Body
    val textHeight: Dp = 20.dp
    val collapsedPlaceholderStyle = PUITextStyle.Caption1
    val collapsedPlaceholderHeight = collapsedPlaceholderStyle.fontSize.dp + 10.dp
    val prominentPlaceholderHeight = textStyle.fontSize.dp
    val prominentPlaceholderOffset = (textHeight - prominentPlaceholderHeight) / 2
    val placeholderStyle = if (isPlaceholderCollapsed) collapsedPlaceholderStyle else textStyle
    val placeholderOffset: Dp by animateDpAsState(
        if (isPlaceholderCollapsed) textHeight
        else prominentPlaceholderOffset, label = ""
    )




    // - Data Modifiers

    fun clearText() {
        text.value = ""
    }

    fun updateText(value: String) {
        text.value = value
        alert.value = null
    }

    fun toggleSecure() {
        secureState.value = !secureState.value
    }


    // - Dynamic Layout

    fun trailingItemsWidth(): Dp {
        return if (isEdited && isSecure) { 60.dp }
        else if (isEdited) { 30.dp }
        else { 0.dp }
    }

    fun leadingItemWidth(): Dp {
        return if (leadingItem == null) { 0.dp }
        else { 30.dp }
    }

    fun placeholderLeadingOffset(): Dp {
        return  if (isEdited || isFocused) { 0.dp }
        else { leadingItemWidth() }
    }

    fun textFieldHorizontalOffset(): Dp {
        return trailingItemsWidth() + leadingItemWidth()
    }

    // - Colors

    val flatColor: Color = Color.PUILabelGray
    val prominentColor: Color = Color.PUILabel


    // - Internal Components

    @Composable
    fun Placeholder(modifier: Modifier) {
        PUILabel(
            modifier = modifier,
            id = id,
            text = placeholder,
            style = placeholderStyle,
            textColor = flatColor,
            tintColor = flatColor
        )
    }

    @Composable
    fun Field(modifier: Modifier) {

        fun visualTransformation(): VisualTransformation {
            return if (secureState.value) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        }

        BasicTextField(
            value = text.value,
            onValueChange = ::updateText,
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            textStyle = textStyle.toSystemTextStyle(color = prominentColor),
            singleLine = true,
            interactionSource = interactionSource,
            visualTransformation = visualTransformation(),
        )

    }


    @Composable
    fun Item(@DrawableRes id: Int, action: () -> Unit) {
        val isPressed = remember { mutableStateOf(false) }
        PUIControl(
            action = action,
            isPressed = isPressed,
            modifier = Modifier
                .controlPressedAppearance(isPressed)
                .requiredSize(30.dp, 20.dp)
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.PUIGray1)
            )
        }
    }


    @Composable
    fun SecureItemIfNeeded() {
        if (isSecure && isEdited) {
            if (secureState.value) {
                Item(R.drawable.eye, action = ::toggleSecure)
            } else {
                Item(R.drawable.eye_slash, action = ::toggleSecure)
            }
        }
    }

    @Composable
    fun ClearItemIfNeeded() {
        if (isEdited) {
            Item(R.drawable.xmark_circle_fill, action = ::clearText)
        }
    }


    @Composable
    fun Separator() {
        Box(modifier = Modifier
            .padding(vertical = PUISpace2)
            .fillMaxWidth()
            .background(Color.PUIGray1)
            .height(1.dp)
        )
    }


    // - Main Layout

   Column(
       modifier = Modifier
           .animateContentSize()
           .then(modifier)
   ) {
       BoxWithConstraints(
           contentAlignment = Alignment.BottomStart,
           modifier = Modifier
               .height(textHeight + collapsedPlaceholderHeight)
               .animateContentSize()
       ) {
           val scope = this
           Row(
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.fillMaxWidth()
           ) {
               leadingItem?.let {
                   Item(id = it.id, action = it.action)
               }
               Field(
                   modifier = Modifier
                       .requiredWidth(scope.maxWidth - textFieldHorizontalOffset())
                       .height(textHeight)
               )
               Row {
                   ClearItemIfNeeded()
                   SecureItemIfNeeded()
               }
           }
           Placeholder(
               modifier = Modifier
                   .padding(
                       bottom = placeholderOffset,
                       start = placeholderLeadingOffset()
                   )
                   .height(textHeight)
           )
       }
       Separator()
       alert.value?.let {
           PUILabel(
               id = it.id,
               text = it.message,
               style = PUITextStyle.Caption1,
               textColor = it.appearance.textColor,
               tintColor = it.appearance.tintColor
           )
       }
   }
}

@Composable
fun PUIEmailField(
    modifier: Modifier = Modifier,
    placeholder: String,
    text: MutableState<String>,
    alert: MutableState<PUIAlert?> = mutableStateOf(null)
) {
    PUITextField(
        modifier = modifier,
        id = R.drawable.at,
        placeholder = placeholder,
        text = text,
        alert = alert,
        isSecure = false,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Email
        )
    )
}

@Composable
fun PUISecureField(
    modifier: Modifier = Modifier,
    placeholder: String,
    text: MutableState<String>,
    alert: MutableState<PUIAlert?>  = mutableStateOf(null)
) {
    PUITextField(
        modifier = modifier,
        id = R.drawable.lock_fill,
        placeholder = placeholder,
        text = text,
        alert = alert,
        isSecure = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = KeyboardType.Password
        )
    )
}