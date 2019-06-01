package iam.thevoid.ae

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.*
import androidx.core.view.ViewCompat
import iam.thevoid.e.safe

/**
 * TRANSITION
 */

var View.transitionNameCompat: String?
    get() = ViewCompat.getTransitionName(this)
    set(value) = ViewCompat.setTransitionName(this, value)

/**
 * MARGIN
 */

var View.marginStart: Int
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.marginStart.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(value, marginTop, marginRight, marginBottom)
        layoutParams = params
    } ?: Unit

var View.marginRight: Int
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(marginLeft, marginTop, value, marginBottom)
        layoutParams = params
    } ?: Unit

var View.marginEnd: Int
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.marginEnd.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(marginLeft, marginTop, value, marginBottom)
        layoutParams = params
    } ?: Unit

var View.marginLeft: Int
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(value, marginTop, marginRight, marginBottom)
        layoutParams = params
    } ?: Unit

var View.marginTop: Int
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(marginLeft, value, marginRight, marginBottom)
        layoutParams = params
    } ?: Unit

var View.marginBottom: Int
    get() = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin.safe
    set(value) = (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
        params.setMargins(marginLeft, marginTop, marginRight, value)
        layoutParams = params
    } ?: Unit

/**
 * VISIBILITY
 */

val View?.gone: Boolean
    get() = this?.visibility == View.GONE

val View?.notGone: Boolean
    get() = this != null && visibility != View.GONE

val View?.visible: Boolean
    get() = this?.visibility == View.VISIBLE

val View?.notVisible: Boolean
    get() = this != null && visibility != View.VISIBLE

val View?.invisible: Boolean
    get() = this?.visibility == View.INVISIBLE

val View?.notInvisible: Boolean
    get() = this != null && visibility != View.INVISIBLE

private fun View?.checkAndSetViewState(state: Int) {
    if (this == null || this.visibility == state)
        return

    visibility = state
}

fun View?.show() = checkAndSetViewState(View.VISIBLE)
fun View?.hide(needHide: Boolean = true) = checkAndSetViewState(if (needHide) View.INVISIBLE else View.VISIBLE)
fun View?.gone(needGone: Boolean = true) = checkAndSetViewState(if (needGone) View.GONE else View.VISIBLE)


/**
 * CLICKABLE
 */

// FULL SQUARE

@TargetApi(value = Build.VERSION_CODES.M)
fun View.setRippleClickForeground() {
    foreground = context.drawable(context.selectableItemBackgroundResource)
    setClickable()
}

fun View.setRippleClickBackground() {
    setBackgroundResource(context.selectableItemBackgroundResource)
    setClickable()
}

fun View.setRippleClickAnimation() =
    if (canUseForeground) setRippleClickForeground() else setRippleClickBackground()

// ROUNDED

/**
 * Looks bad
 */
@Deprecated("Looks bad, use View.setRippleClickBackground() instead")
@TargetApi(value = Build.VERSION_CODES.M)
fun View.setRoundRippleClickForeground() {
    foreground = context.drawable(context.actionBarItemBackgroundResource)
    setClickable()
}

fun View.setRoundRippleClickBackground() {
    setBackgroundResource(context.actionBarItemBackgroundResource)
    setClickable()
}

fun View.setRoundRippleClickAnimation() = setRoundRippleClickBackground()

// HELPER

private val canUseForeground
    get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

fun View.setClickable() {
    isClickable = true
    isFocusable = true
}

/**
 * MEASURE SPEC
 */

val unspecified
    get() = View.MeasureSpec.UNSPECIFIED

val atMost
    get() = View.MeasureSpec.AT_MOST

val exactly
    get() = View.MeasureSpec.EXACTLY

/**
 * HIERARCHY SEARCH
 */

inline fun <reified T : View> ViewGroup.findView(): T? {
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if (view is T) {
            return view
        }
    }

    return null
}

fun View.rootView(): View {
    var root = this
    while (root.parent is View) {
        root = root.parent as View
    }
    return root
}

/**
 * KEYBOARD & FOCUS
 */

fun View.hideKeyboard() {
    clearFocus()
    post {
        (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(windowToken, 0)
    }.safe
}

fun View.showKeyboard() {
    post {
        (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.showSoftInput(this, 0)
    }.safe
}

fun View.resetFocus() {
    clearFocus()
    isFocusableInTouchMode = false
    isFocusable = false
    isFocusableInTouchMode = true
    isFocusable = true
}

/**
 * RESOURCES
 */

fun View.setPaddings(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) =
    setPadding(left, top, right, bottom)

fun View.string(@StringRes res: Int, vararg obj: Any?): String = context.string(res, *obj)

fun View.color(@ColorRes res: Int): Int = context.color(res)

fun View.integer(@IntegerRes res: Int): Int = context.integer(res)

inline fun <reified T : Number> View.dimen(@DimenRes res: Int): T = context.dimen(res)

@Deprecated("Use \"dimen(@DimenRes res: Int)\" instead", level = DeprecationLevel.WARNING)
fun View.dimenPxSize(@DimenRes res: Int): Int = context.dimen(res)

fun View.drawable(@DrawableRes res: Int): Drawable? = context.drawable(res)

fun View.coloredDrawable(@DrawableRes res: Int, @ColorRes colorRes: Int): Drawable? =
    context.coloredDrawable(res, colorRes)

fun View.quantityString(@PluralsRes res: Int, quantity: Int, vararg args: Any?) =
    context.quantityString(res, quantity, *args)

fun View.quantityString(@PluralsRes res: Int, quantity: Int) = context.quantityString(res, quantity)

/**
 * WINDOW
 */

val View.statusBarHeight: Int
    get() = context.statusBarHeight

@JvmOverloads
fun View.getNavigationBarHeight(orientation: Int = Configuration.ORIENTATION_PORTRAIT): Int =
    context.getNavigationBarHeight(orientation)

val View.screenWidth
    get() = context.screenWidth

val View.screenHeight
    get() = context.screenHeight

val View.screenWidthDp
    get() = context.screenWidthDp

val View.screenHeightDp
    get() = context.screenHeightDp

val View.dp: Float
    get() = context.dp

/**
 * ACTIONS
 */

inline fun <reified V : View> V.onFirstAttachToWindow(crossinline whenAttached: V.() -> Unit) {
    addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
        override fun onViewDetachedFromWindow(v: View?) {
            removeOnAttachStateChangeListener(this)
        }

        override fun onViewAttachedToWindow(v: View?) {
            removeOnAttachStateChangeListener(this)
            (v as? V)?.whenAttached()
        }
    })
}

/**
 * INFLATER
 */

val View.inflater
    get() = context.inflater

fun View.inflate(@LayoutRes res: Int, root: ViewGroup? = null, attachToRoot: Boolean = false) =
    context.inflate(res, root, attachToRoot)