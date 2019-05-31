package iam.thevoid.ae

import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.DrawableRes

fun TextView.setTextStrikeThru(strikeThru: Boolean) {
    if (strikeThru) setTextStrikeThru() else setTextNotStrikeThru()
}

fun TextView.setTextStrikeThru() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun TextView.setTextNotStrikeThru() {
    paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}

fun TextView.setTextUnderlined(underlined: Boolean) {
    if (underlined) setTextUnderlined() else setTextNotUnderlined()
}

fun TextView.setTextUnderlined() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

fun TextView.setTextNotUnderlined() {
    paintFlags = paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
}

fun TextView.setDrawableBottom(@DrawableRes res: Int, width: Int = 0, height: Int = width) =
    setDrawableBottom(drawable(res), width, height)

fun TextView.setDrawableBottom(drawable: Drawable?, width: Int = 0, height: Int = width) =
        setDrawables(bottom = drawable, width = width, height = height)

fun TextView.setDrawableTop(@DrawableRes res: Int, width: Int = 0, height: Int = width) =
    setDrawableTop(drawable(res), width, height)

fun TextView.setDrawableTop(drawable: Drawable?, width: Int = 0, height: Int = width) =
        setDrawables(top = drawable, width = width, height = height)

fun TextView.setDrawableRight(@DrawableRes res: Int, width: Int = 0, height: Int = width) =
    setDrawableRight(drawable(res), width, height)

fun TextView.setDrawableRight(drawable: Drawable?, width: Int = 0, height: Int = width) =
        setDrawables(right = drawable, width = width, height = height)

fun TextView.setDrawableLeft(@DrawableRes res: Int, width: Int = 0, height: Int = width) =
    setDrawableLeft(drawable(res), width, height)

fun TextView.setDrawableLeft(drawable: Drawable?, width: Int = 0, height: Int = width) =
        setDrawables(drawable, width = width, height = height)

fun TextView.setDrawables(
    left: Drawable? = null,
    top: Drawable? = null,
    right: Drawable? = null,
    bottom: Drawable? = null,
    width: Int = 0,
    height: Int = 0
) =
    if (width == 0 || height == 0)
        setDrawablesWithIntrinsicBounds(left, top, right, bottom)
    else
        setCompoundDrawables(
            left?.apply { setSize(width, height) },
            top?.apply { setSize(width, height) },
            right?.apply { setSize(width, height) },
            bottom?.apply { setSize(width, height) }
        )

fun TextView.setDrawablesWithIntrinsicBounds(
    left: Drawable? = null,
    top: Drawable? = null,
    right: Drawable? = null,
    bottom: Drawable? = null
) =
    setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
