package com.example.practicandoparcial2

import android.app.Application
import com.example.practicandoparcial2.data.movies
import com.example.practicandoparcial2.repository.MovieRepository

class MovieTrackerApplication: Application() {

    val moviesRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}