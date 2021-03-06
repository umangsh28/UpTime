package com.angel.uptimeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.angel.uptimeapp.BookDetailsActivity
import com.angel.uptimeapp.Mvvm.API.APIClient
import com.angel.uptimeapp.Mvvm.Model2.BestBook.FictionList
import com.angel.uptimeapp.Mvvm.Model2.ForYou.ThrillerList
import com.angel.uptimeapp.Mvvm.Model2.PopularChoice.BusinessList
import com.angel.uptimeapp.Mvvm.Model2.PopularChoice.Item
import com.angel.uptimeapp.Mvvm.Model2.TrendingBook.BookList
import com.angel.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem
import com.angel.uptimeapp.Mvvm.Network.Network
import com.angel.uptimeapp.Mvvm.OnClickListner.OnItemHome
import com.angel.uptimeapp.R
import com.angel.uptimeapp.Recycler.BestBook.FictionAdapter
import com.angel.uptimeapp.Recycler.ForYou.ThrillerAdapter
import com.angel.uptimeapp.Recycler.PopularChoice.BusinessAdapter
import com.angel.uptimeapp.Recycler.Trend.TrendAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home), OnItemHome {

    private var bookList: BookList? = null

    private var fictionList: FictionList? = null

    private var businessList: BusinessList? = null

    private var thrillerList: ThrillerList? = null

    private var Listener: OnItemHome? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TrendingcallApi()

        FictionApi()

        businessApi()

        ThrillerApi()

    }

    private fun ThrillerApi() {
        val APIclientF = Network.getGoogle().create(APIClient::class.java)

        APIclientF.getThriller().enqueue(object : Callback<ThrillerList> {
            override fun onResponse(call: Call<ThrillerList>, response: Response<ThrillerList>) {
                thrillerList = response.body()
                setrecyclerThriller()
            }

            override fun onFailure(call: Call<ThrillerList>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setrecyclerThriller() {
        val adapterbusiness = ThrillerAdapter(thrillerList!!, this)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclerBusinessHack.adapter = adapterbusiness
        RecyclerBusinessHack.layoutManager = linearLayoutManager
    }

    private fun businessApi() {
        val APIclientF = Network.getGoogle().create(APIClient::class.java)

        APIclientF.getBusiness().enqueue(object : Callback<BusinessList> {
            override fun onResponse(call: Call<BusinessList>, response: Response<BusinessList>) {
                businessList = response.body()
                setrecyclerBusiness()
            }

            override fun onFailure(call: Call<BusinessList>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setrecyclerBusiness() {
        val adapterbusiness = BusinessAdapter(businessList!!, this)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclerPersonal.adapter = adapterbusiness
        RecyclerPersonal.layoutManager = linearLayoutManager
    }

    private fun FictionApi() {
        val APIclientF = Network.getGoogle().create(APIClient::class.java)

        APIclientF.getfiction().enqueue(object : Callback<FictionList> {
            override fun onResponse(call: Call<FictionList>, response: Response<FictionList>) {
                fictionList = response.body()
                Log.d("Tag", response.body()!!.items.get(3).volumeInfo.imageLinks.smallThumbnail)
                setrecyclerFiction()
            }

            override fun onFailure(call: Call<FictionList>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setrecyclerFiction() {
        val adapterFiction = FictionAdapter(fictionList!!, this)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclerCollection.adapter = adapterFiction
        RecyclerCollection.layoutManager = linearLayoutManager
    }

    private fun TrendingcallApi() {
        val APIclient = Network.getretro().create(APIClient::class.java)

        APIclient.getBook().enqueue(object : Callback<BookList> {
            override fun onResponse(call: Call<BookList>, response: Response<BookList>) {
                bookList = response.body()
                setrecyclerTrending()
            }

            override fun onFailure(call: Call<BookList>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setrecyclerTrending() {
        val adaptertrend = TrendAdapter(bookList!!, this)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        Recyclertrending.adapter = adaptertrend
        Recyclertrending.layoutManager = linearLayoutManager
    }


    fun swithchToBookDetails(name: String, writer: String, desc: String) {

        val intent = Intent(context, BookDetailsActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("writer", writer)
        intent.putExtra("desc", desc)
        context?.startActivity(intent)
    }


    override fun onTrendBook(result: BookListItem, pos: Int) {

        if(result.longDescription!=null) {
            swithchToBookDetails(result.title, result.authors[0], result.longDescription)
        }else{
            swithchToBookDetails(result.title, result.authors[0]," Premium required to read this")
        }
    }

    override fun onBusinessBook(business: Item, pos: Int) {


        swithchToBookDetails(
            business.volumeInfo.title,
            business.volumeInfo.authors[0],
            business.volumeInfo.description
        )
    }

    override fun onThrillerBook(thriller: com.angel.uptimeapp.Mvvm.Model2.ForYou.Item, pos: Int) {

        swithchToBookDetails(
            thriller.volumeInfo.title,
            thriller.volumeInfo.authors[0],
            thriller.volumeInfo.description
        )
    }

    override fun onFictionalBook(
        fiction: com.angel.uptimeapp.Mvvm.Model2.BestBook.Item,
        pos: Int
    ) {

        swithchToBookDetails(
            fiction.volumeInfo.title,
            fiction.volumeInfo.authors[0],
            fiction.volumeInfo.description
        )
    }
}