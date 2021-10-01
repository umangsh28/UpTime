package com.example.uptimeapp.fragments
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uptimeapp.Mvvm.ViewModel.UviewModel
import com.example.uptimeapp.Recycler.ViewAdapter
import com.example.uptimeapp.Mvvm.Model.ResponseDTO
import com.example.uptimeapp.Mvvm.Repo.Urepositary
import com.example.uptimeapp.Mvvm.ViewModel.UviewFactory
import com.example.uptimeapp.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {


    lateinit var viewAdapter: ViewAdapter

    lateinit var uviewModel: UviewModel

    var responseDTO: ResponseDTO?=null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repo=Urepositary()
        val uviewFactory=UviewFactory(repo)
        uviewModel=
            ViewModelProviders.of(requireActivity(),uviewFactory)
                .get(UviewModel::class.java)



        uviewModel.ApiCalling().observe(viewLifecycleOwner, Observer {
            responseDTO=it

        })

        setrecycler()
    }

    private fun setrecycler() {
        viewAdapter= ViewAdapter(requireContext(),responseDTO!!)

        Recyclertrending.layoutManager=LinearLayoutManager(context)

        Recyclertrending.adapter=viewAdapter

    }

}