package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class Article(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val author: String,
        val content: String,
        val description: String,
        val publishedAt: String,
        val title: String,
        val url: String,
        val urlToImage: String
)