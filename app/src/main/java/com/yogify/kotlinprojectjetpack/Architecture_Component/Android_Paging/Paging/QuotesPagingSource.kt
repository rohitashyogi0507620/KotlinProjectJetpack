package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.DataClass.Quotes
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserAPI
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.QuotesService

class QuotesPagingSource(val quotesapi: QuotesService):PagingSource<Int,Quotes>() {
    override fun getRefreshKey(state: PagingState<Int, Quotes>): Int? {
        return  state.anchorPosition?.let { position->
            val anchoerpage=state.closestPageToPosition(position)
            anchoerpage?.prevKey?.plus(1)?:anchoerpage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quotes> {
        return  try {
            val position=params.key?:1
            val response=quotesapi.getQuotesList(position)

            return LoadResult.Page(data = response.body()!!.results, prevKey = if (position==1)null else position-1
            ,nextKey = if (position==response.body()!!.totalPages) null else position+1)

        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}