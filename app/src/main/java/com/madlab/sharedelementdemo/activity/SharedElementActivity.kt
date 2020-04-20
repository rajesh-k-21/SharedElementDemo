package com.madlab.sharedelementdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.madlab.sharedelementdemo.R
import kotlinx.android.synthetic.main.activity_shared_element.*

class SharedElementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element)

        val techName = intent.getStringExtra("name")
        val techProfile = intent.getIntExtra("image", 0)
        val technologyDetails = intent.getStringExtra("details")

        Glide.with(this).load(techProfile).into(imageViewProfile)
        textViewTechName.text = techName
        textViewTechnologyDetails.text = technologyDetails
    }

    override fun onBackPressed() {
        ActivityCompat.finishAfterTransition(this)
    }
}
