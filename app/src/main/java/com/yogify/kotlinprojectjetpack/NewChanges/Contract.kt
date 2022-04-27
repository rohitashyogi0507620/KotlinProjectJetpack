package com.yogify.kotlinprojectjetpack.NewChanges

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class Contract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String?): Intent {
        var intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("Name", input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
       return "Rohitash Is Here"
    }
}