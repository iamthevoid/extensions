package iam.thevoid.aetest

import android.app.Activity
import android.os.Bundle
import iam.thevoid.ae.hideKeyboard
import iam.thevoid.ae.showKeyboard
import iam.thevoid.ae.string

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard()
        showKeyboard()
        string(R.string.app_name)
    }
}