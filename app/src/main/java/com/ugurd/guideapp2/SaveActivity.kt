 package com.ugurd.guideapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_save.*

 class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val intent = intent
        val getTopicName = intent.getStringExtra("topicname")
        val getIssueName = intent.getStringExtra("topicissue")
        textSavedTopic.text = getTopicName
        textSavedIssue.text = getIssueName

        val topicName = textSavedTopic.text.toString()
        val topicIssue = textSavedIssue.text.toString()
        val topicExplanation = textSavedTopic.text.toString()






        buttonSaved.setOnClickListener {
            val vt = DatabaseHelper(this)
            Topicsdao().topicAdd(vt,topicName,topicIssue,topicExplanation)



        }
    }

}