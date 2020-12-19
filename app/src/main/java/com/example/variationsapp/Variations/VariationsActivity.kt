package com.example.variationsapp.Variations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.variationsapp.R
import com.example.variationsapp.databinding.ActivityMainBinding
import com.example.variationsapp.databinding.ActivityVariationsBinding
import com.example.variationsapp.network.VariationsDetail

class VariationsActivity : AppCompatActivity() {

    private lateinit var viewModel: VariationsViewModel

    private lateinit var binding: ActivityVariationsBinding

    private lateinit var variationsDetail: VariationsDetail

    private lateinit var adapter: VariationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVariationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(VariationsViewModel::class.java)
        observeResponse()
    }

    private fun observeResponse() {
        viewModel.response.observe( this, Observer {
            variationsDetail = it
            binding.loadingImage.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            initAdapter()
        })
    }

    private fun initAdapter() {
        adapter = VariationsAdapter(variationsDetail.variants.variant_groups)
        binding.recyclerView.adapter = adapter
    }
}