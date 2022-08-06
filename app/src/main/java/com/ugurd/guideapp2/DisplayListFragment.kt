package com.ugurd.guideapp2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.fragment_display_list.*

class DisplayListFragment : Fragment() {

    var issueDisplayList = ArrayList<String>()
    var idLlist = ArrayList<Int>()
    private lateinit var listAdapter : DisplayRecyclerAdapter
    private var issues = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: DisplayListFragmentArgs by navArgs()
        val getTopicName = bundle.topicname



try {
    activity?.let {
        issues.clear()
        val vt = DatabaseHelper(it)
        val topicList = Topicsdao().getIssueList(vt,"$getTopicName")
        for ( k in topicList){
            issues.add(k.topic_issue)
            idLlist.add(k.id)
        }
    }
}catch (e:Exception){
    e.printStackTrace()
}
       // listAdapter.notifyDataSetChanged()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display_list, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        listAdapter = DisplayRecyclerAdapter(issues,idLlist)
        recyclerViewDisplay.layoutManager = LinearLayoutManager(context)
        recyclerViewDisplay.adapter = listAdapter


    }

}