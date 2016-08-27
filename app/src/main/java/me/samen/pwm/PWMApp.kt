package me.samen.pwm

import android.app.Application
import me.samen.pwm.data.Data

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : Application() {
    val appData = Data()

    override fun onCreate() {
        super.onCreate()
    }

}