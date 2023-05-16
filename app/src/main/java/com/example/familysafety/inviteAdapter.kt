package com.example.familysafety

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class inviteAdapter(private val listMembers:List<inviteModal>):RecyclerView.Adapter<inviteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): inviteAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_invite,parent,false)
        return inviteAdapter.ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return listMembers.size
    }

    override fun onBindViewHolder(holder: inviteAdapter.ViewHolder, position: Int) {
        val item = listMembers[position]
        holder.name.text = item.name

    }

    class ViewHolder(private val item: View): RecyclerView.ViewHolder(item) {

        val name = item.findViewById<TextView>(R.id.name_invite)

    }
}