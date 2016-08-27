package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data

class SetupActivity : AppCompatActivity() {
    var appData : Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)
        appData = (application as PWMApp).appData
        (findViewById(R.id.editText) as EditText).setOnEditorActionListener { textView, i,
                                                                              keyEvent -> checkPinAndFinish(textView.text.toString())}
    }

    fun checkPinAndFinish(pin: String): Boolean {
        if (pin.equals(appData?.getPin())) {
            appData?.authenticated =true
            finish()
        }
        return true
    }
}
