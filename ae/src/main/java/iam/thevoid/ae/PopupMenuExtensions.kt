package iam.thevoid.ae

import androidx.annotation.IdRes
import androidx.appcompat.widget.PopupMenu

fun PopupMenu.hideItem(@IdRes res : Int, hide : Boolean = true) {
    menu.findItem(res).isVisible = !hide
}

fun android.widget.PopupMenu.hideItem(@IdRes res : Int, hide : Boolean = true) {
    menu.findItem(res).isVisible = !hide
}