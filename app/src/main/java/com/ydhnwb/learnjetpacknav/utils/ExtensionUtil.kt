package com.ydhnwb.learnjetpacknav.utils

import android.app.Activity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun View.OnClick(clickListener: (View) -> Unit) {
    setOnClickListener(clickListener)
}

inline fun EditText.onTextChanged(crossinline textChangeListener: (String) -> Unit) {
    addTextChangedListener { object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            textChangeListener(s.toString())
        }
    } }
}

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <T: View>T.showIf(condition: (T) -> Boolean) : T {
    if (condition(this)) {
        show()
    } else {
        hide()
    }
    return this
}

inline fun <T: View>T.hideIf(condition: (T) -> Boolean) : T {
    if (condition(this)) {
        hide()
    } else {
        show()
    }
    return this
}

fun Unit.safe() = Unit
fun Any.safe() = Unit
fun View.show() = run { this.visibility = View.VISIBLE }
fun View.hide() = run { this.visibility = View.GONE }



