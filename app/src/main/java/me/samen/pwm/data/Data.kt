package me.samen.pwm.data

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
class Data(val appContext: Application) {
    private var _authenticated: Boolean? = null
    var authenticated: Boolean = false
    var accounts: ArrayList<UserAccount> = ArrayList<UserAccount>()
    val prefs: SharedPreferences = appContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun getSugarAcc(): ArrayList<UserAccount> {
        accounts.clear()
        accounts.addAll(SugarRecord.listAll(UserAccount::class.java))
        return accounts
    }

    fun savePin(pin: String): Boolean {
        var editor = prefs.edit()
        editor.putString("pin",pin)
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