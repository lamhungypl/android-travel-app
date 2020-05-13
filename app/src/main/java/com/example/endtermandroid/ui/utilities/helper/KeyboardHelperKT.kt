package com.example.endtermandroid.ui.utilities.helper

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

class KeyboardHelperKT {
    companion object {
        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            val view = activity.currentFocus ?: View(activity)
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}