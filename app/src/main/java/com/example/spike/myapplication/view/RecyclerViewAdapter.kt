package com.example.spike.myapplication.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.spike.myapplication.R
import com.example.spike.myapplication.contract.MainContract
import com.example.spike.myapplication.databinding.RecyclerviewListitemBinding
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.viewmodel.ListItemViewModel
import org.jetbrains.anko.sdk25.coroutines.onClick

class RecyclerViewAdapter constructor(val context: Context, val view: MainContract)
    : RecyclerView.Adapter<RecyclerViewViewHolder>() {

    //private var context: Context
    //private var view: MainContract
    private var listItems = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val binding: RecyclerviewListitemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recyclerview_listitem, parent, false)
        binding.viewModel = ListItemViewModel()
        return RecyclerViewViewHolder(binding.root, binding.viewModel)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val item = listItems[position]
        holder.setItem(item)

        holder.itemView.onClick {
            view.onItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun setItems(items: ArrayList<User>) {
        listItems = items
        notifyDataSetChanged()
    }

    fun addItem(item: User) {
        listItems.add(item)
        notifyDataSetChanged()
    }

    fun addItems(items: ArrayList<User>) {
        listItems = items
        notifyDataSetChanged()
    }

    fun deleteItem(item: User?) {
        item?.let {
            listItems.remove(item)
        } ?: listItems.removeAt(0)

        notifyDataSetChanged()
    }
}