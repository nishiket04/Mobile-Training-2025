package com.nishiket.task.fragment.fragmentsview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import com.nishiket.task.R

class DisplayFragment : Fragment() {
    private lateinit var sentenceText: TextView
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // assigning Id's using function
        findId(view)
        // to get the sentence from main fragment
        parentFragmentManager.setFragmentResultListener(
            "sentence",
            viewLifecycleOwner
        ) { key, bundle ->
            val sentence: String? = bundle.getString("sentence")
            if (sentence != null) sentenceText.setText(sentence) else Log.d(
                "updatedSentenceLog",
                "something went wrong from dis"
            )
            // to send the data which we get from main fragment to modify fragment
            parentFragmentManager.setFragmentResult(
                "fromDisplay",
                bundleOf("fromDisplay" to sentence)
            )
        }
        // reset the sentence
        resetButton.setOnClickListener {
            val resetSentence: String = ""
            // send to main fragment
            parentFragmentManager.setFragmentResult(
                "update",
                bundleOf("UpdateSentence" to resetSentence)
            )
            // send to main modify fragment
            parentFragmentManager.setFragmentResult(
                "fromDisplay",
                bundleOf("fromDisplay" to resetSentence)
            )
            sentenceText.text = resetSentence
        }
    }

    // function to find Id's of the view
    fun findId(view: View) {
        sentenceText = view.findViewById(R.id.sentenceText)
        resetButton = view.findViewById(R.id.resetButton)
    }
}