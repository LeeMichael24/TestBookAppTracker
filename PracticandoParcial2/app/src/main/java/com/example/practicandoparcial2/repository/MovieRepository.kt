package com.example.practicandoparcial2.repository

import com.example.practicandoparcial2.data.Movie

class MovieRepository(private val movies: MutableList<Movie>) {

    fun getMovies() = movies

    fun addMovies(movie: Movie) = movies.add(movie)
}
