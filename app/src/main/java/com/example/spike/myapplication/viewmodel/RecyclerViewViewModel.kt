package com.example.spike.myapplication.viewmodel

import android.databinding.ObservableInt
import android.view.View
import com.example.spike.myapplication.contract.MainContract
import com.example.spike.myapplication.model.User
import com.example.spike.myapplication.util.GitHubService
import com.example.spike.myapplication.util.ui_debug
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.text.SimpleDateFormat
import java.util.*

class RecyclerViewViewModel (val mainView: MainContract) : BaseViewModel() {
    var progressBarVisibility1 = ObservableInt(View.GONE)
    var progressBarVisibility2 = ObservableInt(View.GONE)

    protected val disposables by lazy {
        CompositeDisposable()
    }

    override fun onCreate() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {
        disposables.clear()
    }

    override fun onCleared() {
        //super.onCleared()

        //disposables.clear()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onAddClicked(view: View) {
        ui_debug("")

        progressBarVisibility1.set(View.VISIBLE)

        // Do something
        //val now = System.currentTimeMillis()
        //val date = Date(now)
        //val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date)
        //val user = User(dateFormat, 0)

//        disposables.add(
//        Observable.just(date)
//                .map {
//                    SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date)
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    ui_debug("onNext")
//                    runBlocking { delay(3000) }
//                    progressBarVisibility1.set(View.GONE)
//                    val user = User(it, 0)
//                    mainView.onAdd(user)
//                }, {
//                    ui_debug("onError")
//                    progressBarVisibility1.set(View.GONE)
//                    mainView.onShowError(it.localizedMessage)
//                }, {
//                    ui_debug("onCompleted")
//                })
//        )

        disposables.add(
                GitHubService.getRepositoryList("test")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            ui_debug("GitHubService", "onNext")
                            progressBarVisibility1.set(View.GONE)
                            var aaa = 1
                            val bbb = ArrayList<User>()
                            for (item in it.items) {
                                ui_debug("GitHubService ${item.name}")
                                //mainView.onAdd(User(item.name, aaa++))
                                bbb.add(User(item.name, aaa++))
                            }
                            bbb.add(User("last", bbb.size))
                            mainView.onAdd(bbb)
                        }, {
                            ui_debug("GitHubService", "onError")
                            progressBarVisibility1.set(View.GONE)
                            mainView.onShowError(it.localizedMessage)
                        }, {
                            ui_debug("GitHubService", "onCompleted")
                        })
        )

        //progressBarVisibility1.set(View.GONE)
        //mainView.onAdd(user)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onDeleteClicked(view: View) {
        ui_debug("")

        progressBarVisibility2.set(View.VISIBLE)

        // Do something
        disposables.add(
        Observable.just("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ui_debug("onNext")
                    runBlocking { delay(3000) }
                    progressBarVisibility2.set(View.GONE)
                    mainView.onDelete(null)
                }, {
                    ui_debug("onError")
                    progressBarVisibility2.set(View.GONE)
                    mainView.onShowError(it.localizedMessage)
                }, {
                    ui_debug("onCompleted")
                })
        )

        //progressBarVisibility2.set(View.GONE)
        //mainView.onDelete(null)
    }

    fun onItemSelected(item: User) {
        ui_debug("$item")
    }
}