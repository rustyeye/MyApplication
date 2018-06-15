package com.example.spike.myapplication.contract

import android.view.View
import com.example.spike.myapplication.model.User

interface MainContract {
    fun onFabClicked(view: View)
    fun onAdd(item: User)
    fun onAdd(items: ArrayList<User>)
    fun onDelete(item: User?)
    fun onItemClicked(item: User)
    fun onShowError(error: String)

}