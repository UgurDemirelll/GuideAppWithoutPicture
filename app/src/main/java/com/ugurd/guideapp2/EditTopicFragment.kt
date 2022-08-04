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
import kotlinx.android.synthetic.main.fragment_edit_topic.*
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
        val vt = DatabaseHelper(it)
        val topiclist = Topicsdao().allTopics(vt)
        for ( k in topiclist){
            topics.add(k.topic_name)
        }
    }
    }catch (e : Exception){
        e.printStackTrace()
    }

        view.spinnerEditTopic.adapter = dataAdapter
        view.spinnerEditIssue.adapter = dataAdapter2

        view.buttonEditTopic.setOnClickListener {

            val putTopicName = topics[spinnerEditTopic.selectedItemPosition]
            val putTopicIssue = issues[spinnerEditIssue.selectedItemPosition]
            val data = EditTopicFragmentDirections.actionEditTopicFragmentToEditSaveListFragment(putTopicName,putTopicIssue)

            Navigation.findNavController(it).navigate(data)
        }

        return view
    }

}