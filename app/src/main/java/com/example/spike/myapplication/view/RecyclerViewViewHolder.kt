package com.example.spike.myapplication.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.viewmodel.ListItemViewModel

class RecyclerViewViewHolder constructor(itemView: View, viewModel: ListItemViewModel?) : RecyclerView.ViewHolder(itemView) {
    var viewModel: ListItemViewModel? = null

    init {
        this.viewModel = viewModel
    }

    fun setItem(item: User) {
        viewModel?.setItem(item)
    }
}