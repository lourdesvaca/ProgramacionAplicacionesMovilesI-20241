package com.example.practicaapipersonas.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiacapipersonas.repositories.BookRepository
import com.example.practicaapipersonas.models.Producto

class ProductViewModel : ViewModel() {
    private val _productList = MutableLiveData<List<Producto>>()
    val productList: LiveData<List<Producto>> get() = _productList

    fun fetchProducts() {
        BookRepository.getProducts(
            success = { _productList.value = it },
            failure = { it.printStackTrace() })
    }
}