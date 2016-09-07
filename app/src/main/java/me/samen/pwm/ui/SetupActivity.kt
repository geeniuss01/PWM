package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_setup.*
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data

class SetupActivity : AppCompatActivity() {
    var appData: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_setup)
        val toolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)
        appData = (application as PWMApp).appData
        editTextPin.setOnEditorActionListener { textView, i,
                                                keyEvent ->
            checkPinAndFinish(textView.text.toString())
        }
        editTextPin.post { Runnable { editTextPin.requestFocus() } }
        if (appData?.getPin() == null) {
            textViewInstruction.visibility = View.VISIBLE
            textViewInstruction.text=resources.getString(R.string.setup_choose_pin)
        }
    }

    fun checkPinAndFinish(pin: String): Boolean {
        textViewInstruction.text=""
        if (appData?.getPin() == null && editTextPin.text.toString().length == 4) {
            appData?.savePin(editTextPin.text.toString())
            finish()
        } else if (pin.equals(appData?.getPin())) {
            appData?.authenticated = true
            finish()
        } else {
            textViewInstruction.visibility = View.VISIBLE
            textViewInstruction.text=resources.getString(R.string.setup_wrong_pin)
        }
        return true
    }
}
