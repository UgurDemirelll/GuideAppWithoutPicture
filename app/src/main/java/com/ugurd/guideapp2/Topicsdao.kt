package com.ugurd.guideapp2

import android.annotation.SuppressLint
import android.content.ContentValues

class Topicsdao {

    fun topicAdd(vt : DatabaseHelper, topic_name : String, topic_issue : String, topic_explanation : String){

    val db = vt.writableDatabase
    val values = ContentValues()


    values.put("topic_name",topic_name)
    values.put("topic_issue",topic_issue)
    values.put("topic_explanation",topic_explanation)

    db.insertOrThrow("topics",null,values)
    db.close()



    }

    @SuppressLint("Range")
    fun allTopics (vt : DatabaseHelper) : ArrayList<Topics>{

        val topicsArrayList = ArrayList<Topics>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM topics",null)

        while(cursor.moveToNext()){

            val topic =  Topics(cursor.getInt(cursor.getColumnIndex("id")),
            cursor.getString(cursor.getColumnIndex("topic_name")),
            cursor.getString(cursor.getColumnIndex("topic_issue")),
            cursor.getString(cursor.getColumnIndex("topic_explanation"))
            )
            topicsArrayList.add(topic)
        }
        return topicsArrayList

    }


}