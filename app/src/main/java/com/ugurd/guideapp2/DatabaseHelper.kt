package com.ugurd.guideapp2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context : Context) : SQLiteOpenHelper(context,"Topics",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE topics (id INTEGER PRIMARY KEY AUTOINCREMENT , topic_name TEXT, topic_issue TEXT, topic_explanation TEXT);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS topics")

    }
}