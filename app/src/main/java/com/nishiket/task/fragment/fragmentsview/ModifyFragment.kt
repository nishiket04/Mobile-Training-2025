package com.nishiket.task.fragment.fragmentsview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.bundleOf
import com.nishiket.task.R

class ModifyFragment : Fragment() {
    private lateinit var enableEditImage: ImageView
    private lateinit var modifiableEditText: EditText
    private lateinit var modifyAndSendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modify, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // assigning Id's using function
        findId(view)
        modifiableEditText.isFocusable = false
        // to get the sentence from display fragment
        parentFragmentManager.setFragmentResultListener(
            "fromDisplay",
            viewLifecycleOwner
        ) { key, bundle ->
            val updatedSentence: String? = bundle.getString("fromDisplay")
            if (updatedSentence != null) {
                modifiableEditText.setText(updatedSentence)
            } else {
                Log.d(
                    "updatedSentenceLog",
                    "something went wrong from modify"
                )
            }

            enableEditImage.setOnClickListener {
                modifiableEditText.isFocusable = true
                modifiableEditText.isFocusableInTouchMode = true
                modifiableEditText.requestFocus()
            }
            // modifying data
            modifyAndSendButton.setOnClickListener {
                val updatedSentence: String = modifiableEditText.text.toString()
                // send to main fragment
                parentFragmentManager.setFragmentResult(
                    "update",
                    bundleOf("UpdateSentence" to updatedSentence)
                )
                // send to display fragment
                parentFragmentManager.setFragmentResult(
                    "sentence",
                    bundleOf("sentence" to updatedSentence)
                )

            }
        }
    }

    // function to find Id's of the view
    fun findId(view: View) {
        modifiableEditText = view.findViewById(R.id.modifiableEditText)
        enableEditImage = view.findViewById(R.id.enableEditImage)
        modifyAndSendButton = view.findViewById(R.id.modifyAndSendButton)
    }
}