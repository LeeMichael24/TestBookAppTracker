package com.example.estudiando_para_parcial_mobiles

import android.app.Application
import com.example.estudiando_para_parcial_mobiles.data.books
import com.example.estudiando_para_parcial_mobiles.repository.BookRepository


//debemmos avisarle que se estara sobrescribiuendo por lo tanfo
//vamos al manifiesto y le ponemos el nombre de la clase con el atributo "name"
class BookTrackerApplication: Application() {

    val booksRepository: BookRepository by lazy {
        BookRepository(books)
    }
}