package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.DataClass

data class QuotesData(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Quotes>,
    val totalCount: Int,
    val totalPages: Int
)