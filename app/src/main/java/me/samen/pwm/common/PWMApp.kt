package me.samen.pwm.common

import com.orm.SugarApp
import com.orm.SugarContext

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : SugarApp() {
    val LOG_TAG = "PWMApp"
    //("11235813pentaclevenus5petalrose.")
    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this, "11235813pentaclevenus5petalrose.")).build()
        SugarContext.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }

}