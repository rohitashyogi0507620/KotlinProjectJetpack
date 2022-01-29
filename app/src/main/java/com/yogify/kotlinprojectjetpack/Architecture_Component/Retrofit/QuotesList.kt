package com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit

data class QuotesList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: MutableList<Result>,
    val totalCount: Int,
    val totalPages: Int
)