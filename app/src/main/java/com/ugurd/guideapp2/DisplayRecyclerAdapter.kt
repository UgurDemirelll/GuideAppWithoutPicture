package com.ugurd.guideapp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row_display.view.*

class DisplayRecyclerAdapter(val issueDisplayList : ArrayList<String>, val idList : ArrayList<Int>) : RecyclerView.Adapter<DisplayRecyclerAdapter.TopicHolder>() {
    class TopicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row_display,parent,false)
        return  TopicHolder(view)
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        holder.itemView.text_recycler_display.text = issueDisplayList[position]
        holder.itemView.setOnClickListener {
            val action = DisplayListFragmentDirections.actionDisplayListFragmentToDisplayFragment(idList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return issueDisplayList.size

    }
}