package com.michaelceley.examples.library

import android.util.Log

object Logger {

    const val TAG = "InjectedPrint"

    fun printClickMessage() {
        Log.d(TAG, "View was clicked")
    }

    fun printValueChangeMessage() {
        Log.d(TAG, "View state was toggled")
    }
}