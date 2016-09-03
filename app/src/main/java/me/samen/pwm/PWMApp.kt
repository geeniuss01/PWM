package me.samen.pwm

import android.util.Log
import com.orm.SugarApp
import com.orm.SugarContext
import me.samen.pwm.data.Data

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : SugarApp() {
    val LOG_TAG = "PWMApp"
    var appData : Data? = null
    private val _encUtil = EncryptionUtil("11235813pentaclevenus5petalrose.")
    val encUtil: EncryptionUtil
        get() = _encUtil

    override fun onCreate() {
        super.onCreate()
        appData = Data(this, encUtil)
        SugarContext.init(this)
        var v = _encUtil.encryptMsg("secret_message")
        Log.d(LOG_TAG, encUtil.decryptMsg(v))
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }

}