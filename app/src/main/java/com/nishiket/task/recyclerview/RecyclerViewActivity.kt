package com.nishiket.task.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nishiket.task.R
import com.nishiket.task.recyclerview.adapter.ChatAdapter
import com.nishiket.task.recyclerview.model.Message
import com.nishiket.task.recyclerview.roomdatabase.DatabaseInstance
import java.time.LocalTime

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var messagesRecyclerView: RecyclerView
    private lateinit var msgTypeCheckBox: CheckBox
    private lateinit var messageEditText: EditText
    private lateinit var sendFAB: FloatingActionButton
    private lateinit var chatAdapter: ChatAdapter
    private val chatList: MutableList<Message> = mutableListOf()
    private lateinit var db:DatabaseInstance
    private var edit: Boolean = false // message is selected for edit boolean
    private var itemPosition: Int = -1 // popup menu selected item position
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        // assigning id's using function
        findId()
        // Get the Database instance
        db = DatabaseInstance.getDatabase(this)
        // add all the message to the list
        chatList.addAll(db.chatDao().getChats())
        // To fit ime in screen with editText
        getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
        )

        //set up recycler view
        chatAdapter = ChatAdapter(
            chatList,
            object : ChatAdapter.OptionsMenuClickListener { // implement interface hear
                override fun onOptionsMenuClicked(position: Int, view: View) {
                    performOptionsMenuClick(position, view) // calling method to popup menu
                }
            })
        messagesRecyclerView.adapter = chatAdapter
        messagesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        sendFAB.setOnClickListener {
            if (edit) { // if its edit message
                val message = messageEditText.text.toString().trim()
                val receiver = msgTypeCheckBox.isChecked
                val time = LocalTime.now().toString()
                chatList[itemPosition].message = message
                chatList[itemPosition].msgType = receiver
                chatList[itemPosition].time = time
                val v = db.chatDao().updateChat(chatList[itemPosition]) // update row in the table
                Log.d("TAG", "onCreate: $v")
                chatAdapter.notifyItemChanged(itemPosition)
                messageEditText.text.clear()
                msgTypeCheckBox.isChecked = false
                edit = false // make edit message boolean false
            } else { // if its not edit message, then add
                val message = messageEditText.text.toString().trim()
                val receiver = msgTypeCheckBox.isChecked
                val time = LocalTime.now().toString()
                val id = db.chatDao().insertChat(Message(message=message, time = time, msgType = receiver)) // insert message into table
                chatList.add(Message(id = id.toInt(),message=message, time = time, msgType =  receiver)) // add message to the list with id
                chatAdapter.notifyItemInserted(chatList.size - 1)
                messagesRecyclerView.scrollToPosition(chatList.size-1)
                messageEditText.text.clear()
                msgTypeCheckBox.isChecked = false
            }
        }

    }

    // Function to find Id's of the view
    fun findId() {
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView)
        msgTypeCheckBox = findViewById(R.id.msgTypeCheckBox)
        messageEditText = findViewById(R.id.messageEditText)
        sendFAB = findViewById(R.id.sendFAB)
    }

    private fun performOptionsMenuClick(position: Int, view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.chat_menu)
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.delete -> {
                        val v = db.chatDao().deleteChat(chatList[position]) // delete the message form the table
                        chatList.removeAt(position)
                        Log.d("TAG", "onCreate: $v")
                        chatAdapter.notifyItemRemoved(position)
                        chatAdapter.notifyItemRangeChanged(0, chatList.size - 1)
                        return true
                    }

                    R.id.edit -> {
                        messageEditText.setText(chatList[position].message)
                        msgTypeCheckBox.isChecked = chatList[position].msgType
                        itemPosition = position
                        edit = true // make edit message true
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }
}
