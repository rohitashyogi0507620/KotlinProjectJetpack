package com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yogify.kotlinprojectjetpack.R

class AdapterQuotes : ListAdapter<Result, AdapterQuotes.viewholder>(Diffutil()) {

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val txticon = view.findViewById<TextView>(R.id.txticon)
        val auther = view.findViewById<TextView>(R.id.txtauther)
        val content = view.findViewById<TextView>(R.id.txtcontent)
        val date = view.findViewById<TextView>(R.id.txtpublishdata)

        fun bind(item: Result) {
            txticon.text = item.author.subSequence(0, 1)
            auther.text = item.author
            content.text = item.content
            date.text = item.dateModified.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listview_quotes, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    // Used To Comapir Data

    class Diffutil : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

}