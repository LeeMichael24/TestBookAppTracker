package com.example.estudiando_para_parcial_mobiles.viewModel

import androidx.lifecycle.ViewModel
import com.example.estudiando_para_parcial_mobiles.repository.BookRepository


//la fuente de datos la recibimos a travez de los parametros de nuevo
// en el constructor de la clase BooksViewModel y la guardamos en un atributo
// y este sera nuestro punto de confianza para obtener los datos bien formateados
//creamos la funcion para que la ui no sepa de donde viene la informacion
class BooksViewModel(val bookRepository: BookRepository): ViewModel() {

    fun getBooks() = bookRepository.getBooks()
}