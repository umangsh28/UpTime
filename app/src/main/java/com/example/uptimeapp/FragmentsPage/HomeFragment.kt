package com.example.uptimeapp.FragmentsPage
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummy.Mvvm.ViewModel.UviewModel
import com.example.dummy.Recycler.ViewAdapterr
import com.example.uptimeapp.Mvvm.Model.Result
import com.example.uptimeapp.Mvvm.Repo.Urepositary
import com.example.uptimeapp.Mvvm.ViewModel.UviewFactory
import com.example.uptimeapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var uviewModel: UviewModel
    private var list:List<Result>?=null
//      var responseDTO:  ListResponseDTO

    //    val adapterr=ViewAdapterr(this, responseDTO!!)
    lateinit var adapterr:ViewAdapterr
    lateinit var viewModel:UviewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var repo = Urepositary()
        var viewModelFactory = UviewFactory(repo)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(UviewModel::class.java)

        viewModel.ApiCalling("telugu").observe(viewLifecycleOwner, Observer {
//            responseDTO = it
            adapterr = ViewAdapterr(requireContext(),it)
        })


        var layoutManager = LinearLayoutManager(context)
        Recyclertrending.adapter=adapterr
        Recyclertrending.layoutManager=layoutManager

    }




}