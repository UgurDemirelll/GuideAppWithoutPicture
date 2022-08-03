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

        topics.add("Konu Seç")
        context?.let {
            dataAdapter = ArrayAdapter(it,android.R.layout.simple_list_item_activated_1,android.R.id.text1,topics)
        }
        // veri çekeceğiz

        view.spinnerDisplay.adapter = dataAdapter




        view.buttonDisplayTopic.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_displaySelectFragment_to_displayListFragment)
        }

        return view
    }

}