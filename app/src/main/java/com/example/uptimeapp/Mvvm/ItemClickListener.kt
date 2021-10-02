package com.example.uptimeapp.Mvvm

import com.example.uptimeapp.Mvvm.Model2.TrendingBook.BookListItem


interface ItemClickListener {

    fun onitemClick(result: BookListItem, pos:Int)

}