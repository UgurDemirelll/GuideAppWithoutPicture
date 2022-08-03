package com.ugurd.guideapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_display_select.view.*
import kotlinx.android.synthetic.main.fragment_edit_topic.view.*

class EditTopicFragment : Fragment() {

    private  var topics = ArrayList<String>()
    private var issues = ArrayList<String>()
    private lateinit var dataAdapter : ArrayAdapter<String>
    private lateinit var dataAdapter2 : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_edit_topic, container, false)


try {
    activity?.let {
        topics.add("Konu Seç")
        issues.add("ayraçlar listelenecek")
        dataAdapter = ArrayAdapter(it.applicationContext,android.R.layout.simple_list_item_activated_1,android.R.id.text1,topics)
        dataAdapter2 = ArrayAdapter(it.applicationContext,android.R.layout.simple_list_item_activated_1,android.R.id.text1,issues)
        view.spinnerDisplay.adapter = dataAdapter
        println("try çalışıyor")
        view.spinnerEditIssue.adapter = dataAdapter2
    }
    }catch (e : Exception){
        println("catch çalışıyor")
        e.printStackTrace()
    }



        // veri çekeceğiz





        view.buttonEditTopic.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_editTopicFragment_to_editSaveListFragment)
        }

        return view
    }



}