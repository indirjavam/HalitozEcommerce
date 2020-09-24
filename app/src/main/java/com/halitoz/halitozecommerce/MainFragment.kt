package com.halitoz.halitozecommerce

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halitoz.halitozecommerce.model.Product
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main,container,false)

        val products = arrayListOf<Product>()

        for (i in 0..100){
//            products.add(Product("Organic Apple", "http://via.placeholder.com/350/ffff00/ff0000",1.99))
            products.add(Product("Dress Shirt #$i", "http://via.placeholder.com/350/dddddd/000000",1.99))
        }

        root.recycler_view.apply {
            //            layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = GridLayoutManager(activity,2)
            adapter = ProductsAdapter(products)
        }

        return root
    }
}