package com.nishiket.task.recyclerview.adapter

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nishiket.task.R
import com.nishiket.task.recyclerview.model.Message

class ChatAdapter(
    private val messages: MutableList<Message>,
    private var optionsMenuClickListener: OptionsMenuClickListener
) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    // context of the activity
    private lateinit var context: Context

    // interface to get pass the longed press item position and its root view to anchor it.
    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int, view: View)
    }

    // view Holder to holds view.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageCard: CardView = view.findViewById(R.id.messageCard)
        val messageBackground: RelativeLayout = view.findViewById(R.id.messageBackground)
        val messageTextView: TextView = view.findViewById(R.id.messageTextView)
        val timeTextView: TextView = view.findViewById(R.id.timeTextView)

    }

    // inflate view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val chat = messages[position]
        holder.messageTextView.text = chat.message
        holder.timeTextView.text = chat.time
        val layoutParams = holder.messageCard.layoutParams as RelativeLayout.LayoutParams
        // if message type is receiver
        if (chat.msgType) {
            // changing UI of the receiver message
            holder.messageCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.black))
            holder.messageTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder.timeTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder.timeTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
            // changing its gravity
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START)
            layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_END)
            holder.messageCard.layoutParams = layoutParams
        }

        // when long pressed calls interface method
        holder.messageBackground.setOnLongClickListener { view ->
            optionsMenuClickListener.onOptionsMenuClicked(position, holder.messageBackground)
            false
        }
    }

    // item count
    override fun getItemCount(): Int = messages.size

}