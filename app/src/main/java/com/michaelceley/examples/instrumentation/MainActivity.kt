package com.michaelceley.examples.instrumentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import com.google.android.material.switchmaterial.SwitchMaterial

@Suppress("ObjectLiteralToLambda")
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // These interfaces are purposely implemented as anonymous classes instead of lambdas.
        // When looking at byte code, lambdas are not a one-to-one equivalent with their interface
        // type and thus require extra work to identify with a class visitor. By using anonymous
        // classes for this example, we can quickly look up interface types using AGP ClassData.

        findViewById<Button>(R.id.button_1).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "Button 1 Clicked")
            }
        })

        findViewById<Button>(R.id.button_2).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "Button 2 Clicked")
            }
        })

        findViewById<SwitchMaterial>(R.id.switch_1).setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d(TAG, "Switch value changed: $isChecked")
            }
        })

        findViewById<CheckBox>(R.id.checkbox_1).setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d(TAG, "Checkbox value changed: $isChecked")
            }
        })
    }
}