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

    fun update(vt: DatabaseHelper, id : Int, topic_name : String, topic_issue : String, topic_explanation : String){

        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("topic_name",topic_name)
        values.put("topic_issue",topic_issue)
        values.put("topic_explanation",topic_explanation)
        //db.update("topics",values,"id=?", arrayOf(id.toString()))

        db.update("topics",values,"id=?", arrayOf(id.toString()))
        db.close()

    }
    @SuppressLint("Range")
    fun getIssueList (vt : DatabaseHelper,topicName : String) : ArrayList<Topics> {

        val topicsArrayList = ArrayList<Topics>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM topics WHERE topic_name like  '%$topicName%' ", null)

        while (cursor.moveToNext()) {

            val topic = Topics(
                cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("topic_name")),
                cursor.getString(cursor.getColumnIndex("topic_issue")),
                cursor.getString(cursor.getColumnIndex("topic_explanation"))
            )
            topicsArrayList.add(topic)
            db.close()
        }
        return topicsArrayList
    }



@SuppressLint("Range")
fun getExplanation (vt : DatabaseHelper, topicName : String, topic_issue: String) : Topics? {

    var getExplanation : Topics? = null

    val db = vt.writableDatabase
    val cursor = db.rawQuery("SELECT * FROM topics WHERE topic_name = $topicName ,topic_issue = $topic_issue", null)

    while (cursor.moveToNext()) {

        getExplanation = Topics(
            cursor.getInt(cursor.getColumnIndex("id")),
            cursor.getString(cursor.getColumnIndex("topic_name")),
            cursor.getString(cursor.getColumnIndex("topic_issue")),
            cursor.getString(cursor.getColumnIndex("topic_explanation")))

    }
    return getExplanation
}

}















