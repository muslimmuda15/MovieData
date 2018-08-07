package com.app.rachmad.retrofit.repository

import android.arch.lifecycle.MutableLiveData
import com.app.rachmad.retrofit.`object`.MovieBaseData
import com.app.rachmad.retrofit.`object`.MovieData
import com.app.rachmad.retrofit.webservice.AccessSite
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieRepository{
    val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    val movieLiveData = MutableLiveData<List<MovieData>>()

    fun movie(){
        val service = retrofit.create(AccessSite::class.java)
        val call = service.movieSite(1)

        movieLiveData.value = null
        call.enqueue(object: Callback<MovieBaseData> {
            override fun onFailure(call: Call<MovieBaseData>?, t: Throwable?) {
                movieLiveData.value = null
            }

            override fun onResponse(call: Call<MovieBaseData>?, response: Response<MovieBaseData>?) {
                if(response != null){
                    val data = response.body()
                    if(data != null){
                        if(response.code() == 200 && response.isSuccessful){
                            movieLiveData.value = data.results
                        }
                        else{
                            movieLiveData.value = null
                        }
                    }
                }
            }

        })
    }
}