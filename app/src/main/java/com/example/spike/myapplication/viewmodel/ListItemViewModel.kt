package com.example.spike.myapplication.viewmodel

import android.databinding.ObservableField
import com.example.spike.myapplication.model.User

class ListItemViewModel {
    var imageUrl = ObservableField<String>()
    var userName = ObservableField<String>()

    fun setItem(item: User) {
        imageUrl.set(item.imageUrl.get())
        userName.set("${item.name.get()} ${item.age.get()}")
    }
}