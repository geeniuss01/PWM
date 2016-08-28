package me.samen.pwm.data

import com.orm.dsl.Table

/**
 * pojo
 *
 * Created by santosh on 27/8/16.
 */

@Table
class UserAccount(val website: String, val username: String, val pwd: String) {

}