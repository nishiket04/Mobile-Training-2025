package com.nishiket.task.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nishiket.task.R
import com.nishiket.task.retrofit.Users

class UserRecylerViewAdapter(private val users:List<Users>): RecyclerView.Adapter<UserRecylerViewAdapter.ViewHolder>() {
    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val email: TextView = view.findViewById(R.id.email)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserRecylerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.retrofit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserRecylerViewAdapter.ViewHolder, position: Int) {
        holder.name.text = users[position].name
        holder.email.text = users[position].email
    }

    override fun getItemCount(): Int = users.size
}