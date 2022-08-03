package com.ugurd.guideapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
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
        topics.add("Konu Seç")
        topics.add("başka konu")
        issues.add("ayraçlar listelenecek")
        

try {
    activity?.let {

        dataAdapter = ArrayAdapter(it,android.R.layout.simple_list_item_activated_1,android.R.id.text1,topics)
        dataAdapter2 = ArrayAdapter(it,android.R.layout.simple_list_item_activated_1,android.R.id.text1,issues)
        view.spinnerEditTopic.adapter = dataAdapter
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