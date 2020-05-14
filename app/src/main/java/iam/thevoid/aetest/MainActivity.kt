package iam.thevoid.aetest

import android.app.Activity
import android.os.Bundle
import android.view.View
import iam.thevoid.ae.*
import iam.thevoid.util.weak

class MainActivity : Activity() {

    var weakRef by weak<Activity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard()
        showKeyboard()
        string(R.string.app_name)
        View(this).dimen<Int>(android.R.dimen.app_icon_size)
        weakRef = this
    }
}