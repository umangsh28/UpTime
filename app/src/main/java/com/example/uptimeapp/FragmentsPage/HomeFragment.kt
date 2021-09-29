package com.example.uptimeapp.FragmentsPage
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummy.Mvvm.ViewModel.UviewModel
import com.example.dummy.Recycler.ViewAdapter
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {


    private var responseDTO: ResponseDTO?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initv()


        setrecycler()
    }




    private fun initv() {
        val uviewModel= ViewModelProvider(this).get(UviewModel::class.java)
        uviewModel.dataByView.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                responseDTO=it
                Log.d("Tag",it.toString())
            }else{
                Toast.makeText(context,"Error message", Toast.LENGTH_LONG).show()
                Log.d("Tag","Errorrrrrrr")
            }
        })
        uviewModel.MakeAPI()
    }

    private fun setrecycler() {
        val linearLayoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        val adapter= responseDTO?.let { context?.let { it1 -> ViewAdapter(it1, it) } }
        Recyclertrending.layoutManager= linearLayoutManager
        Recyclertrending.adapter=adapter
    }

}