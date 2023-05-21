package com.example.estudiando_para_parcial_mobiles.repository

import com.example.estudiando_para_parcial_mobiles.data.Author
import com.example.estudiando_para_parcial_mobiles.data.Book

//a travez del atributo de la clase books,
// podemos acceder a la lista de libros
// que se encuentra en el archivo DummyData.kt
class BookRepository(private val books: List<Book>) {

    fun getBooks() = books

    fun getBookById(author: Author) = books.filter {book -> book.authors.contains(author)  }
}