package com.example.coffeeapp.uilover.coffeeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.uilover.coffeeapp.domain.CategoryDomain
import com.example.coffeeapp.uilover.coffeeapp.repository.MainRepository

class MainViewModel: ViewModel() {

    private val repository= MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryDomain>>{
        return repository.loadCategory()
    }
}