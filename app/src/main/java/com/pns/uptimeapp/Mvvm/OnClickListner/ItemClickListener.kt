package com.pns.uptimeapp.Mvvm.OnClickListner

import com.pns.uptimeapp.Mvvm.Model2.PopularChoice.Item
import com.pns.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem


interface OnItemHome {

    fun onTrendBook(result: BookListItem, pos:Int)

    fun onBusinessBook(business:Item,pos: Int)

    fun onThrillerBook(thriller:com.pns.uptimeapp.Mvvm.Model2.ForYou.Item, pos : Int)

    fun onFictionalBook(fiction :com.pns.uptimeapp.Mvvm.Model2.BestBook.Item, pos:Int)

}