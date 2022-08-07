package com.ugurd.guideapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_display_select.view.*
import kotlinx.android.synthetic.main.fragment_edit_topic.*
import kotlinx.android.synthetic.main.fragment_edit_topic.view.*

class EditTopicFragment : Fragment() {

    private var topics = ArrayList<String>()
    private var issues = ArrayList<String>()
    private lateinit var dataAdapter: ArrayAdapter<String>
    private lateinit var dataAdapter2: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_edit_topic, container, false)
        topics.add("Konu Seç")
        topics.add("başka konu")
        issues.add("ayraçlar listelenecek")
        context?.let {
            topics.clear()
            val vt = DatabaseHelper(it)
            val topiclist = Topicsdao().allTopics(vt)
            val topicset = mutableSetOf<String>()
            for (k in topiclist) {
                topicset.add(k.topic_name)
            }
            for (t in topicset){
                topics.add(t)
            }
            dataAdapter = ArrayAdapter(it, android.R.layout.simple_list_item_activated_1, android.R.id.text1, topics)
            view.spinnerEditTopic.adapter = dataAdapter
        }

        view.spinnerEditTopic.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        context?.let {
            issues.clear()
        val vtg = DatabaseHelper(it)
        val topic = topics[spinnerEditTopic.selectedItemPosition]
        val issueList = Topicsdao().getIssueList(vtg, "$topic")
        for (k in issueList) {
            issues.add(k.topic_issue)
        }

        dataAdapter2 = ArrayAdapter(it, android.R.layout.simple_list_item_activated_1, android.R.id.text1, issues)
        view.spinnerEditIssue.adapter = dataAdapter2
}
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        view.buttonEditTopic.setOnClickListener {

            val putTopicName = topics[spinnerEditTopic.selectedItemPosition]
            val putTopicIssue = issues[spinnerEditIssue.selectedItemPosition]
            //val data = EditTopicFragmentDirections.actionEditTopicFragmentToEditSaveListFragment(putTopicName, putTopicIssue)
            val data = EditTopicFragmentDirections.actionEditTopicFragmentToEditSaveFragment(putTopicName,putTopicIssue)
            Navigation.findNavController(it).navigate(data)
        }

        return view
    }



}





