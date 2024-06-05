package io.padam.android_ui.customer.atoms.controls

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.coroutines.cancellation.CancellationException

@Composable
internal fun PUIControl(
    modifier: Modifier = Modifier,
    action: () -> Unit,
    isPressed: MutableState<Boolean>? = null,
    isActive: Boolean = true,
    content: @Composable() (() -> Unit)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .pointerInput(Unit) {
                if (isActive) {
                    this.detectTapGestures(onPress = {
                        isPressed?.value = true
                        val released = try {
                            tryAwaitRelease()
                        } catch (c: CancellationException) {
                            false
                        }
                        if (released) {
                            isPressed?.value = false
                            action()
                        } else {
                            isPressed?.value = false
                        }
                    })
                }

            }.then(modifier)
    ) {
        content()
    }
}

internal fun Modifier.controlPressedAppearance(isPressed: MutableState<Boolean>) = then(
    alpha(if (isPressed.value) .3f else 1f)
)