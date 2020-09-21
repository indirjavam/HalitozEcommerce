package com.halitoz.halitozecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.product_detail.*

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)

        val title = intent.getStringExtra("title")
        product_name.text = title
    }
}
