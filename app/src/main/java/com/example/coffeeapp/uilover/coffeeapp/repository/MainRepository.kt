package com.example.coffeeapp.uilover.coffeeapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeeapp.uilover.coffeeapp.domain.CategoryDomain
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class MainRepository {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadCategory(): LiveData<MutableList<CategoryDomain>>{
        val listData= MutableLiveData<MutableList<CategoryDomain>>()
        val ref=firebaseDatabase.getReference( "Category")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list=mutableListOf<CategoryDomain>()
                for(childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(CategoryDomain::class.java)
                    item?.let{list.add(it)}
                }
                listData.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    return listData
    }


}