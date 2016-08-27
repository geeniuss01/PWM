package me.samen.pwm.data

/**
 * Handles user prefs, SugarORM DB, all strings are encrypted before storing to db
 *
 * Created by santosh on 27/8/16.
 */
class Data {
    fun getAccounts(): Array<UserAccount> = arrayOf<UserAccount>(UserAccount("site", "user",
            "pwd"), UserAccount("site1", "user1", "pwd1"),UserAccount("site2", "use2r", "pwd2"))

    fun addAccount(acc:UserAccount):Boolean = false

}