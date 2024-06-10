package com.example.practicaapipersonas.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiacapipersonas.repositories.GenderRepository
import com.example.practicaapipersonas.models.Categorias

class MainViewModel : ViewModel() {
    private val _categoryList: MutableLiveData<Categorias> by lazy {
        MutableLiveData<Categorias>(Categorias())
    }
    val categoryList: LiveData<Categorias> get() = _categoryList


    fun fetchListaPersonas() {
        GenderRepository.getCategoryList(
            success = { personas ->
                personas?.let {

                    _categoryList.value = it
                }
            },
            failure = {
                it.printStackTrace()
            })

    }
}