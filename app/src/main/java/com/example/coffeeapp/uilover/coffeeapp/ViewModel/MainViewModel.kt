package com.example.coffeeapp.uilover.coffeeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.uilover.coffeeapp.domain.BannerModel
import com.example.coffeeapp.uilover.coffeeapp.domain.CategoryModel
import com.example.coffeeapp.uilover.coffeeapp.domain.ItemsModel
import com.example.coffeeapp.uilover.coffeeapp.repository.MainRepository

class MainViewModel: ViewModel() {

    private val repository= MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }


    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }
    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>>{
        return repository.loadItemsCategory(categoryId)
    }

}
