package me.samen.pwm.data

import com.orm.SugarRecord

/**
 * Handles user prefs, SugarORM DB, all strings are encrypted before storing to db
 *
 * Created by santosh on 27/8/16.
 */
class Data {
    private var _authenticated: Boolean? = null
    var authenticated: Boolean = false

    fun getAccounts(): Array<UserAccount> {
        try {
            return SugarRecord.listAll(UserAccount::class.java).toTypedArray()
        } catch (e: Exception) {
            return arrayOf<UserAccount>(UserAccount("site", "user",
                    "pwd"), UserAccount("site1", "user1", "pwd1"),UserAccount("site2", "use2r", "pwd2"))
        }
    }

    fun addAccount(acc:UserAccount):Boolean = false

    fun editAccount(acc:UserAccount):Boolean = false

    fun deleteAccount(acc:UserAccount):Boolean = false

    fun savePin(pin: String) = false

    fun getPin(): String = "1313"

    fun convert(): Array<UserAccount> {
        val elems = arrayListOf<UserAccount>()
        return elems.toTypedArray()
    }
}