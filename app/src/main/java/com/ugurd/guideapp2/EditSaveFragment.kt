package com.ugurd.guideapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_save.*
import kotlinx.android.synthetic.main.fragment_edit_save.view.*

class EditSaveFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_edit_save, container, false)
        val bundle:EditSaveFragmentArgs by navArgs()
        val getTopicName = bundle.topicname
        val getTopicIssue = bundle.topicissue
        var id : Int

        view.textEditTopic.setText(getTopicName)
        view.textEditIssue.setText(getTopicIssue)

        activity?.let {

            val vt = DatabaseHelper(it)
            val topicList = Topicsdao().getIssueList(vt,"$getTopicName")

            for (k in topicList){
                if(k.topic_issue == getTopicIssue){
                    val explanation = k.topic_explanation
                    id = k.id
                    println("if deki id : $id")
                    view.textEditExplanation.setText(explanation)
                    view.textViewid.text = id.toString()
                }
            }
        }
        view.buttonEditSave.setOnClickListener {
            context?.let {
                val vtu = DatabaseHelper(it)
                println("editsave içindeki id : ${textViewid.text.toString()}")
                val ids = view.textViewid.text.toString()
                view.textViewid.toString()
                val idsint = ids.toString()
                println(ids)
                val sid = 1
                Topicsdao().update(vtu,ids.toInt(),"${textEditTopic.text.toString()}","${textEditIssue.text.toString()}","${textEditExplanation.text.toString()}")
                //Topicsdao().update(vtu,ids.toInt(),view.textEditTopic.text.toString(),view.textEditIssue.text.toString(),view.textEditExplanation.text.toString())

            }
            Navigation.findNavController(it).navigate(EditSaveFragmentDirections.actionEditSaveFragmentToEditTopicFragment())
            
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("on viewcreatde içindeki id: ${textViewid.text}")


    }







}