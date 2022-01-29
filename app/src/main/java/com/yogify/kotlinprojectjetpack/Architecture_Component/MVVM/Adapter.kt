package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yogify.kotlinprojectjetpack.R

class Adapter : ListAdapter<ProgramingItem, Adapter.viewholder>(Diffutil()) {

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txtname)
        val initail = view.findViewById<TextView>(R.id.txticon)

        fun bind(item: ProgramingItem) {
            name.text = item.name
            initail.text = item.initial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    // Used To Comapir Data

    class Diffutil : DiffUtil.ItemCallback<ProgramingItem>() {
        override fun areItemsTheSame(oldItem: ProgramingItem, newItem: ProgramingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgramingItem, newItem: ProgramingItem): Boolean {
            return oldItem == newItem
        }

    }
}