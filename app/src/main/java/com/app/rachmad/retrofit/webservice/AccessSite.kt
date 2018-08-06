package com.app.rachmad.retrofit.webservice

import com.app.rachmad.retrofit.`object`.MovieBaseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AccessSite{

    @GET("/3/movie/now_playing?api_key=aaddea52a73aa3d1af17bbdd6ddb924d&language=en-us")
    fun movieSite(
            @Query("page") page: Int
    ): Call<MovieBaseData>
}