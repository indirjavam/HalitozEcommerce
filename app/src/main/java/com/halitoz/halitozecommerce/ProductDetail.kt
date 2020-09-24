package com.halitoz.halitozecommerce

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_detail.*

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)

        val title = intent.getStringExtra("title")
        val photoUrl = intent.getStringExtra("photo_url")
        product_name.text = title
        Picasso.get().load(photoUrl).into(photo)

        availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Hey, $title is in stock!")
                .setPositiveButton("OK") { dialog, which -> }
                .create()
                .show()
        }
//        Secenek -2
    /*    availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("It's in stock!")
                .setPositiveButton("OK") { dialog, which -> }
                .create()
                .show()
        }*/
    }
}
