package me.samen.pwm

import android.app.Application
import me.samen.pwm.data.Data

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : Application() {
    var appData: Data? = null

    override fun onCreate() {
        super.onCreate()
        appData= Data();
    }

}