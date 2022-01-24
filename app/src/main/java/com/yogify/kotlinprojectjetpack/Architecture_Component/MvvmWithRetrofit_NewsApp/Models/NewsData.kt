package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)