package com.michaelceley.examples.library

import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView

@Suppress("unused")
object Logger {

    private const val TAG = "InjectedPrint"

    // Methods must be marked as @JvmStatic to use the invokestatic instruction.

    @JvmStatic
    fun printContentChangedMessage() {
        Log.d(TAG, "Window content was changed via setContentView.")
    }

    @JvmStatic
    fun printViewDetails(view: View) {
        Log.d(TAG, "View clicked of type: ${view.javaClass.simpleName}")
        (view as? TextView)?.let {
            Log.d(TAG, "Text shown in clicked view: ${it.text}")
        }
    }

    @JvmStatic
    fun printValueChangeDetails(compoundButton: CompoundButton?, isChecked: Boolean) {
        compoundButton?.let {
            Log.d(TAG, "Value changed on view of type: ${it.javaClass.simpleName}")
            Log.d(TAG, "Value of toggle control: $isChecked")
        }
    }
}