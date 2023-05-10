package org.android.go.sopt.util

import android.content.Context
import android.widget.Toast

fun Context.makeToastMessage(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}