package com.halitoz.halitozecommerce

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.halitoz.halitozecommerce.model.Product

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val products = arrayListOf<Product>()

        for (i in 0..100){
//            products.add(Product("Organic Apple", "http://via.placeholder.com/350/ffff00/ff0000",1.99))
            products.add(Product("Organic Apple", "http://via.placeholder.com/350/dddddd/000000",1.99,"Ebeni Sikim"))
        }

        recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = ProductsAdapter(products)
        }
    }
}
