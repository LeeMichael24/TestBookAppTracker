package com.example.estudiando_para_parcial_mobiles.data

data class Book(
    val title: String,
    val authors: List<Author>,
    val publisher: Publisher,
    val publicationYear: String,
    val pageCount: Int,
    val subject: String,
    val summary: String,
    val isbn: String,
)