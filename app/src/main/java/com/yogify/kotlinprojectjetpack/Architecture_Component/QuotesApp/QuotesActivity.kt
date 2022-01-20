package com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule.MainViewModule
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule.Quotes
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule.ViewModuleFactory
import com.yogify.kotlinprojectjetpack.Architecture_Component.ViewModule.MainViewModuleFactory
import com.yogify.kotlinprojectjetpack.R

class QuotesActivity : AppCompatActivity() {

    lateinit var mainViewModule: MainViewModule;

    private val quotestext: TextView
        get() = findViewById(R.id.txt_quotes)
    private val quoteswritor: TextView
        get() = findViewById(R.id.txt_writer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        mainViewModule = ViewModelProvider(
            this,
            ViewModuleFactory(application)
        ).get(MainViewModule::class.java)

        setQuotes(mainViewModule.getQuotes())

    }

    fun setQuotes(quotes: Quotes) {
        quotestext.text = quotes.content
        quoteswritor.text = quotes.author
    }

    fun OnPrevious(view: android.view.View) {
        setQuotes(mainViewModule.previousQuotes())
    }

    fun OnNext(view: android.view.View) {
        setQuotes(mainViewModule.nextQuotes())
    }

    fun OnShare(view: android.view.View) {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModule.getQuotes().content)
        startActivity(intent)
    }
}