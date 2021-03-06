package com.yogify.kotlinprojectjetpack.NewChanges

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.yogify.kotlinprojectjetpack.R

class FirstActivity : AppCompatActivity() {
    lateinit var txt: TextView
    lateinit var permissionbnt: Button
    private val contract = registerForActivityResult(Contract()) {
        txt.text = it
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        txt = findViewById(R.id.txtview)
        permissionbnt = findViewById(R.id.btn_permission)

    }

    fun fun_startactivity(view: View) {
        //contract.launch("I Am From Main Activity")
        Log.d("ActivityForResult", "First activity")

        startActivityForResult.launch(
            Intent(
                applicationContext, SecondActivity::class.java
            )
        )
    }

    private val startActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { actiivtyresult ->
            if (actiivtyresult.resultCode == 1002) {
                Log.d("ActivityForResult", "Result Method Called")
                txt.text = actiivtyresult.data?.getStringExtra("Name").toString()
                Log.d("ActivityForResult", actiivtyresult.data?.getStringExtra("Name").toString())

            }
        }

    // Request For Multi Permsion
    private val multiPermissionCallback =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            //handle individual results if desired
            map.entries.forEach { entry ->
                when (entry.key) {

                    Manifest.permission.CAMERA ->
                        permissionbnt.isEnabled = entry.value
                    Manifest.permission.READ_CONTACTS ->
                        // permissionbnt.isEnabled = entry.value
                        Toast.makeText(applicationContext, "Contact Done", Toast.LENGTH_SHORT)
                            .show()


                }
            }
        }

    private val singlePermissionCallback =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            //handle individual results if desired
            if (it) {
                Toast.makeText(applicationContext, "Location Done", Toast.LENGTH_SHORT)
                    .show()
                permissionbnt.isEnabled = it


            }

        }


    /**
     * Function for starting multiple permission request
     */
    fun fun_RequestPermission(view: View) {
        multiPermissionCallback.launch(
            arrayOf(
                Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS
            )
        )
    }

    fun fun_SingleRequestPermission(view: View) {
        singlePermissionCallback.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private val requestImageFromGallery =
        registerForActivityResult(ActivityResultContracts.GetContent()) { imageurl ->
            if (imageurl != null) {
                Log.d("ActivityForResult", imageurl.toString())
            }
        }

    fun fun_getimages(view: View) {
        //requestImageFromGallery.launch("image/*")
        requestImageFromGallery.launch("video/*")
    }

    fun fun_capturevideo(view: View) {
        val imageUri: Uri = Uri.parse("Sdgdsg");
        //requestCapturePhoto.launch(imageUri)
    }

    private val requestCapturePhoto =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { imageurl ->
            if (imageurl != null) {
                Log.d("ActivityForResult", imageurl.toString())
            }
        }

}