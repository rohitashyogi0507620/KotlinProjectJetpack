package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.LocalDataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article

@Dao
interface ArticleDAO {
    @Insert
    suspend fun addArticles(articles: List<Article>)

    @Query("select * from news")
    fun getArticles(): List<Article>
}