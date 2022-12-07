package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.Models.Product
import com.yogify.kotlinprojectjetpack.LiveData.imageFromurl
import com.yogify.kotlinprojectjetpack.R

class AdapterProduct(var context: Context) : ListAdapter<Product, AdapterProduct.viewholder>(Diffutil()) {

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.txt_title)
        val category = view.findViewById<TextView>(R.id.txt_category)
        val image = view.findViewById<ImageView>(R.id.img_image)

        fun bind(item: Product,context: Context) {
            title.text = item.title
            category.text = item.category
            Glide.with(context).load(item.image).into(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item,context)
    }

    // Used To Comapir Data

    class Diffutil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}