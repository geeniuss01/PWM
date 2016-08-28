package me.samen.pwm.data

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * Handles user prefs, SugarORM DB, all strings are encrypted before storing to db
 *
 * Created by santosh on 27/8/16.
 */
class Data(val appContext: Application) {
    private var _authenticated: Boolean? = null
    var authenticated: Boolean = false
    val database = AppDB(appContext)
    var accounts: ArrayList<UserAccount> = ArrayList<UserAccount>()
    val prefs: SharedPreferences = appContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun getUAccounts(): ArrayList<UserAccount> {
        try {
            val cursor = database.writableDatabase.query(AppDB.TableContract.TABLE_ACC, AppDB.TableContract.COLUMNS_ACC, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                accounts.clear()
                do {
                    val userAcc = UserAccount(cursor.getString(1), cursor.getString(2), cursor.getString(3))
                    userAcc.id = cursor.getInt(0)
                    accounts.add(userAcc)
                } while (cursor.moveToNext())
            }
            return accounts
        } catch (e: Exception) {
            return arrayListOf<UserAccount>(UserAccount("site", "user",
                    "pwd"), UserAccount("site1", "user1", "pwd1"), UserAccount("site2", "use2r", "pwd2"))
        }
    }

    fun addAccount(acc: UserAccount): Boolean {
        var cv = ContentValues()
        cv.put(AppDB.TableContract.COLUMNS_ACC[1], acc.website)
        cv.put(AppDB.TableContract.COLUMNS_ACC[2], acc.username)
        cv.put(AppDB.TableContract.COLUMNS_ACC[3], acc.pwd)
        database.writableDatabase.insert(AppDB.TableContract.TABLE_ACC, null, cv)
        return true
    }

    fun editAccount(acc: UserAccount): Boolean {
        var cv = ContentValues()
        cv.put(AppDB.TableContract.COLUMNS_ACC[1], acc.website)
        cv.put(AppDB.TableContract.COLUMNS_ACC[2], acc.username)
        cv.put(AppDB.TableContract.COLUMNS_ACC[3], acc.pwd)
        database.writableDatabase.update(AppDB.TableContract.TABLE_ACC,  cv, "${AppDB
                .TableContract.COLUMNS_ACC[0]}=${acc.id}",null)
        return true
    }

    fun deleteAccount(acc: UserAccount): Boolean {
        database.writableDatabase.delete(AppDB.TableContract.TABLE_ACC, "${AppDB.TableContract.COLUMNS_ACC[0]}=${acc.id}",null)
        return true
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