package com.example.uptimeapp.Mvvm.OnClickListner

import com.example.uptimeapp.Mvvm.Model2.PopularChoice.Item
import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem


interface OnItemHome {

    fun onTrendBook(result: BookListItem, pos:Int)

    fun onBusinessBook(business:Item,pos: Int)

    fun onThrillerBook(thriller:com.example.uptimeapp.Mvvm.Model2.ForYou.Item,pos : Int)

    fun onFictionalBook(fiction :com.example.uptimeapp.Mvvm.Model2.BestBook.Item,pos:Int)

}