package me.samen.pwm.data

import com.orm.dsl.Table

/**
 * pojo
 *
 * Created by santosh on 27/8/16.
 */

@Table
class UserAccount(val website: String, var username: String, var pwd: String){
    var id: Long? = null
    // empty constructor is needed for sugar
    constructor() : this("","","")
}