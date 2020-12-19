package com.example.variationsapp.Variations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.variationsapp.network.Variants
import com.example.variationsapp.network.VariationsApi
import com.example.variationsapp.network.Variations
import com.example.variationsapp.network.VariationsDetail
import kotlinx.coroutines.launch
import java.lang.Exception

class VariationsViewModel: ViewModel() {

    private val _response = MutableLiveData<VariationsDetail>()
    val response: LiveData<VariationsDetail>
        get() = _response


    init {
        initApi()
    }

    private fun initApi() {
        viewModelScope.launch {
            try {
                val variationsDetail = VariationsApi.retrofitservice.getVariations()
               _response.value = variationsDetail
            } catch (e: Exception) {
               println(e.message)
            }
        }
    }

}