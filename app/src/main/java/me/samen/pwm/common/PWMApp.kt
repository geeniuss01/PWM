package me.samen.pwm.common

import android.util.Log
import com.orm.SugarApp
import com.orm.SugarContext

/**
 * Created by santosh on 27/8/16.
 */
class PWMApp : SugarApp() {
    val LOG_TAG = "PWMApp"
    val appData by lazy { Data(this, encUtil) }
    private val _encUtil = EncryptionUtil("11235813pentaclevenus5petalrose.")
    val encUtil: EncryptionUtil
        get() = _encUtil

    override fun onCreate() {
        super.onCreate()
        SugarContext.init(this)
        val v = _encUtil.encryptMsg("secret_message")
        Log.d(LOG_TAG, encUtil.decryptMsg(v))
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }

}