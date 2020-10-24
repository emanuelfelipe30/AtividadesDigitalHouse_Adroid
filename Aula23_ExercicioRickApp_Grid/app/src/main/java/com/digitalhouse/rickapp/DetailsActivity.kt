package com.digitalhouse.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    private val image by lazy { findViewById<ImageView>(R.id.imgDetails) }
    private val name by lazy { findViewById<TextView>(R.id.txtNameDetails) }
    private val planet by lazy { findViewById<TextView>(R.id.txtPlanetDetails) }
    private val gender by lazy { findViewById<TextView>(R.id.txtGenderDetails) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val urlParameter = intent.getStringExtra("URL")
        val nameParameter = intent.getStringExtra("NAME")
        val planetParameter = intent.getStringExtra("SPECIES")
        val genderParameter = intent.getStringExtra("GENDER")

        Picasso.get()
            .load(urlParameter)
            .into(image)

        name.text = nameParameter
        planet.text = "Species: $planetParameter"
        gender.text = "Gender: $genderParameter"
    }
}