package me.samen.pwm.common

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.orm.SugarRecord
import java.util.*

/**
 * Handles user prefs, SugarORM DB, all strings are encrypted before storing to db
 *
 * Created by santosh on 27/8/16.
 */
class Data(val appContext: Application, val encryptionUtil: EncryptionUtil) {
    private var _authenticated: Boolean? = null
    var authenticated: Boolean = false
    var accounts: ArrayList<UserAccount> = ArrayList<UserAccount>()
    val prefs: SharedPreferences = appContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun getSugarAcc(): ArrayList<UserAccount> {
        accounts.clear()
        accounts.addAll(SugarRecord.listAll(UserAccount::class.java))
        accounts.map {
            it.website = encryptionUtil.decryptMsg(it._website!!)
            it.username = encryptionUtil.decryptMsg(it._username!!)
            it.pwd = encryptionUtil.decryptMsg(it._pwd!!)
        }
        return accounts
    }

    fun encrpt(ua: UserAccount): UserAccount {
        ua._website = encryptionUtil.encryptMsg(ua.website!!)
        ua.website = null
        ua._username = encryptionUtil.encryptMsg(ua.username!!)
        ua.username = null
        ua._pwd = encryptionUtil.encryptMsg(ua.pwd!!)
        ua.pwd = null
        return ua
    }

    fun savePin(pin: String): Boolean {
        var editor = prefs.edit()
        editor.putString("pin", pin)
        editor.commit()
        return true
    }

    fun getPin(): String? {
        return prefs.getString("pin", null)
    }

    fun convert(): Array<UserAccount> {
        val elems = arrayListOf<UserAccount>()
        return elems.toTypedArray()
    }
}