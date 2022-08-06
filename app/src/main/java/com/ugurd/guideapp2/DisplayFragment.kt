package com.ugurd.guideapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_display.*

class DisplayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_display, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val selectId = DisplayFragmentArgs.fromBundle(it).id
            println("selectid : $selectId")
            context?.let {
                try {
                    val vt = DatabaseHelper(it)
                    val topicList = Topicsdao().getIdList(vt,selectId)
                    for(k in topicList){
                        textDisplayTitle.text = k.topic_name
                        textDisplayIssue.text = k.topic_issue
                        textDisplayExplanation.text = k.topic_explanation
                        println("açılan id : ${k.id}")

                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }

    }

}