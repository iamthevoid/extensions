package iam.thevoid.aetest

import android.app.Activity
import android.os.Bundle
import iam.thevoid.ae.hideKeyboard
import iam.thevoid.ae.showKeyboard
import iam.thevoid.ae.string
import iam.thevoid.util.weak

class MainActivity : Activity() {

    var weakRef by weak<Activity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard()
        showKeyboard()
        string(R.string.app_name)
        weakRef = this
    }
}