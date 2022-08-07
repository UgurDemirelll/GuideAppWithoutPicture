package com.ugurd.guideapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_display_select.*
import kotlinx.android.synthetic.main.fragment_display_select.view.*

class DisplaySelectFragment : Fragment() {

    private  val topics = ArrayList<String>()
    private lateinit var dataAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display_select, container, false)

        //topics.add("Konu Seç")
        topics.clear()

        context?.let {

            val vt = DatabaseHelper(it)
            val topicList = Topicsdao().allTopics(vt)
            for (k in topicList){
                topics.add(k.topic_name)
                val topicset = mutableSetOf<String>()
                for (t in topics){
                    topicset.add(t)
                }
                topics.clear()
                for(z in topicset){
                    topics.add(z)
                }


            }
            dataAdapter = ArrayAdapter(it,android.R.layout.simple_list_item_activated_1,android.R.id.text1,topics)

        }
        view.spinnerDisplay.adapter = dataAdapter
        view.buttonDisplayTopic.setOnClickListener {
            val putTopicName = topics[spinnerDisplay.selectedItemPosition].toString()
            val data = DisplaySelectFragmentDirections.actionDisplaySelectFragmentToDisplayListFragment(putTopicName)
            Navigation.findNavController(it).navigate(data)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}