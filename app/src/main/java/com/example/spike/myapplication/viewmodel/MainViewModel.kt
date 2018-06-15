package com.example.spike.myapplication.viewmodel

import android.databinding.ObservableField
import android.support.design.widget.Snackbar
import android.view.View
import com.example.spike.myapplication.contract.MainContract
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.util.ui_debug

class MainViewModel (val mainView: MainContract) : BaseViewModel() {
    var user : User = User("MainViewModel", 0)
    var userName = ObservableField<String>()

    override fun onCreate() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        user.age.set(user.age.get() + 1)
        userName.set(user.toString())
    }

    override fun onPause() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCleared() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onTextViewClicked(view: View) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        user.age.set(user.age.get() + 1)
        userName.set(user.toString())
    }

    fun onFabClicked(view: View) {
        ui_debug("")
        mainView.onFabClicked(view)
    }
}