package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.Paging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.DataClass.Quotes
import com.yogify.kotlinprojectjetpack.R

class AdapterQuotes(var context: Context, var articles: List<Quotes>) :
    RecyclerView.Adapter<AdapterQuotes.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tilte = view.findViewById<TextView>(R.id.txt_tile)
        val description = view.findViewById<TextView>(R.id.txt_description)
        val image = view.findViewById<ImageView>(R.id.imageview_news)

        fun bind(item: Quotes) {
            tilte.text = item.author
            description.text = item.content
//            Glide
//                .with(itemView.context)
//                .load(item.urlToImage)
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(image);

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_newsarticle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles.get(position))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun updateListItem(articlelist: List<Quotes>) {
        articles = articlelist
        notifyDataSetChanged()

    }

}