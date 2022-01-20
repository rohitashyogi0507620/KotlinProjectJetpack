package com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset


class MainViewModule(var context: Context) : ViewModel() {

    private var quoteslist: Array<Quotes> = emptyArray()
    private var index = 0;

    init {
        quoteslist = loadQuotesfromAccest()
    }

    private fun loadQuotesfromAccest(): Array<Quotes> {

        val inputstrem = context.assets.open("Quotes.json")
        val size: Int = inputstrem.available()
        val buffer = ByteArray(size)
        inputstrem.read(buffer)
        inputstrem.close()
        val json = String(buffer, Charsets.UTF_8)
        var gson = Gson()
        return gson.fromJson(json, Array<Quotes>::class.java)

    }

    fun getQuotes() = quoteslist[index]
    fun nextQuotes(): Quotes {
        if (index != quoteslist.size-1) {
            return quoteslist[++index]
        } else {
            return quoteslist[index]
        }
    }

    fun previousQuotes(): Quotes {
        if (index != 0) {
            return quoteslist[--index]
        } else {
            return quoteslist[index]
        }
    }


}

