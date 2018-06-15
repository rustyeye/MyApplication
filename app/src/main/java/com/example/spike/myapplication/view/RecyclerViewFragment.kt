package com.example.spike.myapplication.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.LinearLayout
import com.example.spike.myapplication.R
import com.example.spike.myapplication.contract.MainContract
import com.example.spike.myapplication.databinding.FragmentRecyclerBinding
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.util.ui_debug
import com.example.spike.myapplication.viewmodel.RecyclerViewViewModel

class RecyclerViewFragment : Fragment(), MainContract {

    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var viewModel: RecyclerViewViewModel

    private val fragmentMainView by lazy {
        view?.findViewById(R.id.fragment_main_view) as LinearLayout
    }

    private val recyclerView1 by lazy {
        view?.findViewById(R.id.recycler_view_1) as RecyclerView
    }

    private val recyclerView2 by lazy {
        view?.findViewById(R.id.recycler_view_2) as RecyclerView
    }

    private var adapter1: RecyclerViewAdapter? = null
    private var adapter2: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = RecyclerViewViewModel(this as MainContract)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler, container, false)
        binding.setViewModel(viewModel)

        viewModel.onCreate()
        binding.executePendingBindings()

        var view = binding.getRoot()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter1 = RecyclerViewAdapter(activity as Context, this as MainContract)
        adapter2 = RecyclerViewAdapter(activity as Context, this as MainContract)

        adapter1?.setItems(ArrayList<User>().apply {
            add(User("User", 0))
        })

        recyclerView1.adapter = (adapter1)
        recyclerView2.adapter = (adapter2)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onFabClicked(view: View) {
        ui_debug("")
    }

    override fun onAdd(item: User) {
        ui_debug("$item")
        adapter1?.addItem(item)
    }

    override fun onAdd(items: ArrayList<User>) {
        ui_debug("$items")
        adapter1?.addItems(items)
    }

    override fun onDelete(item: User?) {
        ui_debug("$item")
        adapter1?.deleteItem(item)
        item?.let {
            adapter2?.addItem(item)
        }
    }

    override fun onItemClicked(item: User) {
        ui_debug("$item")
        viewModel.onItemSelected(item)
    }

    override fun onShowError(error: String) {
        Snackbar.make(fragmentMainView, error, Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }
}