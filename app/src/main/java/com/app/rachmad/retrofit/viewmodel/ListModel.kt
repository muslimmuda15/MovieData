package com.app.rachmad.retrofit.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.app.rachmad.retrofit.`object`.MovieData
import com.app.rachmad.retrofit.repository.MovieRepository

class ListModel: ViewModel(){
    val movieRepository: MovieRepository = MovieRepository()

    fun movie() = movieRepository.movie()
    fun getMovieLiveList(): LiveData<List<MovieData>> = movieRepository.movieLiveData
}