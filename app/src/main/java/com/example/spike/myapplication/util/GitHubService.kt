package com.example.spike.myapplication.util

import android.util.Log
import com.example.spike.myapplication.BuildConfig
import com.example.spike.myapplication.model.RepositoryItem
import com.example.spike.myapplication.model.RepositoryModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class GitHubService {
    interface IGitHubService {
        @GET("/search/repositories")
        fun getRepositoryList(@Query("q") query: String): Observable<RepositoryModel>

        @GET("repos/{owner}/{name}")
        fun getDetailInfo(@Path("owner") owner: String, @Path("name") repoName: String): Observable<RepositoryItem>
    }

    companion object {
        val API_BASE_URL = "https://api.github.com"

        fun getRepositoryList(query: String): Observable<RepositoryModel> {
            return GitHubService.createService(IGitHubService::class.java).getRepositoryList(query)
        }

        private fun <T> createService(service: Class<T>): T {
            return Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createOkHttpClient())
                    .build()
                    .create(service)
        }

        private fun createOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                ui_debug("API LOG", it)
            })
            if (BuildConfig.DEBUG)
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            else
                interceptor.level = HttpLoggingInterceptor.Level.NONE

            return OkHttpClient.Builder()
                    .addNetworkInterceptor(interceptor)
                    .build()
        }
    }
}