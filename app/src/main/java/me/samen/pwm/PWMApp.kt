package me.samen.pwm

import android.app.Application
import me.samen.pwm.data.Data

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : Application() {
    private var _appData: Data = null!!
    var appData:Data
        get() = _appData
        set(value) {
            _appData = value
        };

    override fun onCreate() {
        super.onCreate()
        appData= Data();
    }

}