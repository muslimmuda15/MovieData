package com.app.rachmad.retrofit.`object`

data class MovieBaseData(
        val results: List<MovieData>,
        val page: Int,
        val total_results: Int,
        val total_pages: Int
)

data class MovieData(
        val vote_count: Int,
        val id: Int,
        val video: Boolean,
        val vote_average: Float,
        val title: String,
        val popularity: Float,
        val poster_path: String,
        val original_language: String,
        val original_title: String,
        val genre_ids: List<String>,
        val overview: String,
        val release_date: String
)