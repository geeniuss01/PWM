package me.samen.pwm.common

import com.orm.dsl.Table

/**
 * pojo
 *
 * Created by santosh on 27/8/16.
 */

@Table
class UserAccount(var website: String?, var username: String?, var pwd: String?){
    var id: Long? = null
    var _website:ByteArray? = null
    var _username:ByteArray? = null
    var _pwd:ByteArray? = null

    // empty constructor is needed for sugar
    constructor() : this(null,null,null)
}