package com.ugurd.guideapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_save_topic.*

class SaveTopicActivity : AppCompatActivity() {

    private  val topics = ArrayList<String>()
    private lateinit var dataAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_topic)

        buttonBackToMain.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        topics.add("Yeni Konu Ekle")
        topics.add("ekleme")

        //veri çekeceğiz
        val vt = DatabaseHelper(this)
        val topicList = Topicsdao().allTopics(vt)
        for(k in topicList){
            topics.add((k.topic_name))
        }

        spinnerSave.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val edit = findViewById(R.id.textSaveTopic) as TextView
                if(topics[spinnerSave.selectedItemPosition] == "Yeni Konu Ekle"){
                    edit.isEnabled = true
                    edit.setText("")
                    edit.setHint("Yeni Konu Ekle")
                }else{
                    edit.setText(topics[spinnerSave.selectedItemPosition])
                    edit.isEnabled = false
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }





        dataAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,topics)
        spinnerSave.adapter = dataAdapter


        buttonSaveNext.setOnClickListener {
            val intent = Intent(applicationContext,SaveActivity::class.java)
            intent.putExtra("topicname",textSaveTopic.text.toString())
            intent.putExtra("topicissue",textSaveIssue.text.toString())
            startActivity(intent)
        }
    }
}