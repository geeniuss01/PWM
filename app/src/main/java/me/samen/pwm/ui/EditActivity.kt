package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data

class EditActivity : AppCompatActivity() {
    var appData: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        appData = (application as PWMApp).appData!!
    }
}
