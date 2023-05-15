package com.example.familysafety

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class memberAdapter(private val listMembers: List<MemberModal>) : RecyclerView.Adapter<memberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): memberAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_member,parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: memberAdapter.ViewHolder, position: Int) {
        val item = listMembers[position]
        holder.name.text = item.name
        holder.address.text = item.address
        holder.battery.text = item.battery
        holder.distance.text = item.distance
    }

    override fun getItemCount(): Int {
        return listMembers.size
    }

    class ViewHolder(private val item:View): RecyclerView.ViewHolder(item) {

        val image = item.findViewById<ImageView>(R.id.img_user)
        val name = item.findViewById<TextView>(R.id.name)
        val address = item.findViewById<TextView>(R.id.address)
        val distance = item.findViewById<TextView>(R.id.distance_value)
        val battery = item.findViewById<TextView>(R.id.battery_percent)

    }
}