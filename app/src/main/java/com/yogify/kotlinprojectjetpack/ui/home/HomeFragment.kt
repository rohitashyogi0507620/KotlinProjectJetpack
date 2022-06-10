package com.yogify.kotlinprojectjetpack.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.Hilt_Dependency.HiltActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.PagingActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.LifeCycleObserver.LifecycleActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM.MVVMActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.MvvmRetrofitActivity
import com.yogify.kotlinprojectjetpack.LiveData.LiveDataActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.QuotesActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit.RetrofitActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.RoomDataBaseActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.ViewModule.ViewModuleWorkActivity
import com.yogify.kotlinprojectjetpack.Architecture_Component.WorkManager.WorkManagerActivity
import com.yogify.kotlinprojectjetpack.NewChanges.FirstActivity
import com.yogify.kotlinprojectjetpack.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        binding.btnquotesApp.setOnClickListener {
            startActivity(Intent(context, QuotesActivity::class.java))
        }
        binding.btnlifecycleobserver.setOnClickListener {
            startActivity(Intent(context, LifecycleActivity::class.java))
        }
        binding.btnviewmodule.setOnClickListener {
            startActivity(Intent(context, ViewModuleWorkActivity::class.java))
        }
        binding.btnroomdatabase.setOnClickListener {
            startActivity(Intent(context, RoomDataBaseActivity::class.java))
        }
        binding.btnmvvmData.setOnClickListener {
            startActivity(Intent(context, MVVMActivity::class.java))
        }
        binding.btnmvvmwithretrofit.setOnClickListener {
            startActivity(Intent(context, MvvmRetrofitActivity::class.java))
        }
        binding.btnworkmanager.setOnClickListener {
            startActivity(Intent(context, WorkManagerActivity::class.java))
        }
        binding.pagepagging.setOnClickListener {
            startActivity(Intent(context, PagingActivity::class.java))
        }
        binding.startactivityforresult.setOnClickListener {
            startActivity(Intent(context, FirstActivity::class.java))
        }
        binding.startHiltactivity.setOnClickListener {
            startActivity(Intent(context, HiltActivity::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}