package iam.thevoid.ae

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

/**
 * ACTIVITY
 */

fun Context.asActivity(): Activity = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.asActivity()
    else -> throw IllegalStateException("Context $this NOT contains activity!")
}

fun Context.asFragmentActivity(): FragmentActivity = when (this) {
    is FragmentActivity -> this
    is Activity -> throw IllegalStateException("Context $this NOT support-v4 Activity")
    is ContextWrapper -> baseContext.asFragmentActivity()
    else -> throw IllegalStateException("Context $this NOT contains activity!")
}

fun Context.permissionGranted(permission: String) =
        packageManager.checkPermission(permission, packageName) == PackageManager.PERMISSION_GRANTED

fun Context.permissionsGranted(permission: String, vararg permissions: String): Boolean {
    var granted = permissionGranted(permission)

    if (permissions.isNotEmpty()) {
        for (p in permissions) {
            granted = granted && permissionGranted(p)
        }
    }

    return granted
}


/**
 * WINDOW
 */

val Context?.screenWidth
    get() = if (this == null) 0 else DisplayMetrics().apply {
        asActivity().windowManager?.defaultDisplay?.getMetrics(this)
    }.widthPixels

val Context?.screenHeight
    get() = if (this == null) 0 else DisplayMetrics().apply {
        asActivity().windowManager?.defaultDisplay?.getMetrics(this)
    }.heightPixels

val Context?.screenWidthDp
    get() = this?.asActivity()?.let { screenWidth / dp }

val Context?.screenHeightDp
    get() = this?.asActivity()?.let { screenHeight / dp }

val Context?.dp: Float
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, this?.asActivity()?.resources?.displayMetrics)

val Context?.statusBarHeight: Int
    get() = if (this == null) 0 else resources.getIdentifier("status_bar_height", "dimen", "android")
            .let { id -> if (id > 0) dimen(id) else 0 }

@JvmOverloads
fun Context?.getNavigationBarHeight(orientation: Int = Configuration.ORIENTATION_PORTRAIT): Int =
        if (this == null) 0 else (if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_height_landscape").let { name ->
            resources.getIdentifier(name, "dimen", "android").let { id -> if (id > 0) dimen(id) else 0 }
        }

/**
 * RESOURCES
 */

fun Context?.string(@StringRes res: Int, vararg any: Any?) = this?.getString(res, *any).safe

fun Context?.color(@ColorRes res: Int) = if (this == null) 0 else ContextCompat.getColor(this, res)

inline fun <reified T : Number> Context?.dimen(@DimenRes res: Int): T =
        (if (this == null) 0f else resources.getDimension(res)).let { dimen ->
            when (T::class) {
                Float::class -> dimen as T
                Int::class -> dimen.toInt() as T
                Double::class -> dimen.toDouble() as T
                Long::class -> dimen.toLong() as T
                Short::class -> dimen.toShort() as T
                else -> throw IllegalArgumentException("Unknown dimen type")
            }
        }

fun Context?.drawable(@DrawableRes res: Int): Drawable? =
        if (this == null) null else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) getDrawable(res) else resources.getDrawable(res)

fun Context?.coloredDrawable(@DrawableRes drawableResId: Int, @ColorRes filterColorResourceId: Int): Drawable? =
        drawable(drawableResId).apply { this?.setColorFilter(color(filterColorResourceId), PorterDuff.Mode.SRC_ATOP) }

fun Context?.quantityString(@PluralsRes res : Int, quantity : Int, vararg args : Any?) =
        if (this == null) "" else resources.getQuantityString(res, quantity, *args)

fun Context?.quantityString(@PluralsRes res : Int, quantity : Int) = quantityString(res, quantity, quantity)

fun Context.uriFromResource(@DrawableRes resId: Int): String = Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(resources.getResourcePackageName(resId))
        .appendPath(resources.getResourceTypeName(resId))
        .appendPath(resources.getResourceEntryName(resId))
        .build().toString()

val Context.actionBarSizeResourse: Int
    get() =
        getResourceIdAttribute(android.R.attr.actionBarSize)

val Context.selectableItemBackgroundResource: Int
    get() =
        getResourceIdAttribute(android.R.attr.selectableItemBackground)

val Context.actionBarItemBackgroundResource: Int
    get() =
        getResourceIdAttribute(android.R.attr.actionBarItemBackground)

fun Context.getResourceIdAttribute(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attribute, typedValue, true)
    theme.resolveAttribute(attribute, typedValue, true)
    return typedValue.resourceId
}