package me.samen.pwm.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
class AppDB(context: Context) : SQLiteOpenHelper(context,"accdb",null, 1) {
    object TableContract{
        @JvmField val TABLE_ACC = "uacc"
        @JvmField val COLUMNS_ACC: Array<String> = arrayOf("id", "wsite", "uname", "pwd")

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table ${TableContract.TABLE_ACC} (${TableContract.COLUMNS_ACC[0]} INTEGER PRIMARY KEY AUTOINCREMENT, ${TableContract.COLUMNS_ACC[1]} TEXT, ${TableContract.COLUMNS_ACC[2]}  TEXT,  ${TableContract.COLUMNS_ACC[3]} TEXT) ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}