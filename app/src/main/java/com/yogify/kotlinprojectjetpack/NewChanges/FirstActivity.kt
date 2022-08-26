package com.yogify.kotlinprojectjetpack.NewChanges

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.yogify.kotlinprojectjetpack.R
import java.io.File

class FirstActivity : AppCompatActivity() {
    lateinit var txt: TextView
    lateinit var permissionbnt: Button
    lateinit var imageuri: Uri
    lateinit var videouri: Uri
    lateinit var image: ImageView

    private val contract = registerForActivityResult(Contract()) {
        txt.text = it
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        txt = findViewById(R.id.txtview)
        permissionbnt = findViewById(R.id.btn_permission)
        image = findViewById(R.id.imgview)

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

    // Capture Image From camera
    fun fun_captureimage(view: View) {
        imageuri = createImageUri()!!
        contractCaptureImage.launch(imageuri)

    }

    fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "camera_photo.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.yogify.kotlinprojectjetpack.fileProvider",
            image
        )
    }

    private val contractCaptureImage =
        registerForActivityResult(ActivityResultContracts.TakePicture()) {
            image.setImageURI(null)
            image.setImageURI(imageuri)
        }


    // Take Picture from Gallery
    fun fun_getimages(view: View) {
        requestImageFromGallery.launch("image/*")
    }

    private val requestImageFromGallery =
        registerForActivityResult(ActivityResultContracts.GetContent()) { imageurl ->
            if (imageurl != null) {
                Log.d("ActivityForResult", imageurl.toString())
                image.setImageURI(imageurl)
            }
        }

    // Take Video from Gallery
    fun fun_getvideo(view: View) {
        requestVideoFromGallery.launch("video/*")
    }

    private val requestVideoFromGallery =
        registerForActivityResult(ActivityResultContracts.GetContent()) {videouri->
            image.setImageURI(null)
            image.setImageURI(videouri)
        }

    fun fun_capturevideo(view: View) {
        videouri = createVideoUri()!!
        contractCaptureVideo.launch(videouri)
    }

    fun createVideoUri(): Uri? {
        val image = File(applicationContext.filesDir, "camera_video.mp4")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.yogify.kotlinprojectjetpack.fileProvider",
            image
        )
    }

    private val contractCaptureVideo =
        registerForActivityResult(ActivityResultContracts.TakeVideo()) {
            image.setImageURI(null)
            image.setImageURI(videouri)
        }

}