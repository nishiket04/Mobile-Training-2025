package com.nishiket.task.fragment.fragmentsview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import com.nishiket.task.R

class MainFragment : Fragment() {
    private lateinit var sentenceEditText: EditText
    private lateinit var sendSentenceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate:  of main")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // assigning Id's using function
        findId(view)
        // to send sentence to other fragment
        sendSentenceButton.setOnClickListener {
            val sentence: String = sentenceEditText.text.toString()
            parentFragmentManager.setFragmentResult("sentence", bundleOf("sentence" to sentence))
        }
        // to receive sentence from modify fragment and display fragment
        parentFragmentManager.setFragmentResultListener(
            "update",
            viewLifecycleOwner
        ) { key, bundle ->
            val updatedSentence: String? = bundle.getString("UpdateSentence")
            if (updatedSentence != null) sentenceEditText.setText(updatedSentence) else Log.d(
                "updatedSentenceLog",
                "something went wrong from main" + updatedSentence
            )
        }
    }

    // function to find Id's of the view
    fun findId(view: View) {
        sentenceEditText = view.findViewById(R.id.sentenceEditText)
        sendSentenceButton = view.findViewById(R.id.sendSentenceButton)
    }
}