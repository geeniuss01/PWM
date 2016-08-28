package me.samen.pwm

import android.app.Application
import com.orm.SugarContext
import me.samen.pwm.data.Data

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : Application() {
    var appData : Data? = null

    override fun onCreate() {
        super.onCreate()
        appData = Data(this)
        //SugarContext.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }

}