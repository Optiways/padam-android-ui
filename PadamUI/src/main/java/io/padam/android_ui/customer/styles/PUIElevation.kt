package io.padam.android_ui.customer.styles

import android.graphics.BlurMaskFilter
import android.graphics.Typeface.NORMAL
import android.util.Size
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// public typealias Components = (offset: CGSize, radius: CGFloat, color: UIColor, opacity: Float)

enum class PUIElevation(val offset: Size, val radius: Dp, val color: Color, val alpha: Float) {

    Low(Size(0, 0), 10.dp, Color.Black, .2f),

    Prominent(Size(0, 0), 20.dp, Color.Black, .15f),

    High(Size(0, 0), 30.dp, Color.Black, .2f)
}

fun Modifier.setElevation(elevation: PUIElevation?): Modifier {
    elevation?.let {
        return drawBehind {
            drawIntoCanvas { canvas ->
                val paint = Paint()
                val frameworkPaint = paint.asFrameworkPaint()
                if (it.radius != 0.dp) {
                    frameworkPaint.maskFilter =
                        (BlurMaskFilter(it.radius.toPx(), BlurMaskFilter.Blur.NORMAL))
                }

                frameworkPaint.color = it.color.copy(alpha = it.alpha).toArgb()
                val leftPixel = it.offset.width.dp.toPx()
                val topPixel = it.offset.height.dp.toPx()
                val rightPixel = size.width + topPixel
                val bottomPixel = size.height + leftPixel
                canvas.drawRect(
                    left = leftPixel,
                    top = topPixel,
                    right = rightPixel,
                    bottom = bottomPixel,
                    paint = paint,
                )
            }
        }
    }
    return this
  //  return this.shadow(elevation?.radius ?: 0.dp, shape = shape)
}

