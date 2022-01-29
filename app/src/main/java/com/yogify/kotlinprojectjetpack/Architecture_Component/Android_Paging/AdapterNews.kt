package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging

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
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article
import com.yogify.kotlinprojectjetpack.R

class AdapterNews(var context: Context, var articles: List<Article>) :
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tilte = view.findViewById<TextView>(R.id.txt_tile)
        val description = view.findViewById<TextView>(R.id.txt_description)
        val image = view.findViewById<ImageView>(R.id.imageview_news)

        fun bind(item: Article) {
            tilte.text = item.title
            description.text = item.description
            Glide
                .with(itemView.context)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_newsarticle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles.get(position))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun updateListItem(articlelist: List<Article>) {
        articles = articlelist
        notifyDataSetChanged()

    }

}