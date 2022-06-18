package com.michaelceley.examples.library

import android.util.Log

object Logger {

    private const val TAG = "InjectedPrint"

    @JvmStatic
    fun printClickMessage() {
        Log.d(TAG, "View was clicked")
    }

    @JvmStatic
    fun printValueChangeMessage() {
        Log.d(TAG, "View state was toggled")
    }
}