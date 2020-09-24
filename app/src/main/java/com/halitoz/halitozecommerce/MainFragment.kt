package com.halitoz.halitozecommerce

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.halitoz.halitozecommerce.model.Product
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main,container,false)

/*        val products = arrayListOf<Product>()

        for (i in 0..100){
//            products.add(Product("Organic Apple", "http://via.placeholder.com/350/ffff00/ff0000",1.99))
            products.add(Product("Dress Shirt #$i", "http://via.placeholder.com/350/dddddd/000000",1.99))
        }*/


        doAsync {
            val json = URL("https://finepointmobile.com/data/products.json").readText()

            uiThread {
                d("daniel","json: $json")
                val products = Gson().fromJson(json,Array<Product>::class.java).toList()

                root.recycler_view.apply {
                    //            layoutManager = LinearLayoutManager(this@MainActivity)
                    layoutManager = GridLayoutManager(activity,2)
                    adapter = ProductsAdapter(products)
                    root.progressBar.visibility = View.GONE
                }
            }
        }



        return root
    }
}