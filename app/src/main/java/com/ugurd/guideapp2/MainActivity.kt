package com.ugurd.guideapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDisplay.setOnClickListener {
            val intent = Intent(applicationContext,DisplayActicity::class.java)
            startActivity(intent)
        }
        buttonSave.setOnClickListener {
            val intent = Intent(applicationContext,SaveTopicActivity::class.java)
            startActivity(intent)
        }
        buttonEdit.setOnClickListener {
            val intent = Intent(applicationContext,EditSaveActivity::class.java)
            startActivity(intent)
        }
    }
}