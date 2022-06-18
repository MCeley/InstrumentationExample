package com.michaelceley.examples.library

import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView

object Logger {

    private const val TAG = "InjectedPrint"

    // Methods must be marked as @JvmStatic to use the invokestatic instruction.

    @JvmStatic
    fun printClickMessage() {
        Log.d(TAG, "View was clicked")
    }

    @JvmStatic
    fun printValueChangeMessage() {
        Log.d(TAG, "View state was toggled")
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