package com.example.estudiando_para_parcial_mobiles.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.estudiando_para_parcial_mobiles.BookTrackerApplication
import com.example.estudiando_para_parcial_mobiles.repository.BookRepository


//la fuente de datos la recibimos a travez de los parametros de nuevo
// en el constructor de la clase BooksViewModel y la guardamos en un atributo
// y este sera nuestro punto de confianza para obtener los datos bien formateados
//creamos la funcion para que la ui no sepa de donde viene la informacion


//Para que sirve crear una factory? para que cuando se cree una instancia de la
// clase BooksViewModel se le pase como parametro el bookRepository que es el que
// tiene la lista de libros y asi poder acceder a ella desde la clase BooksViewModel.
class BooksViewModel(private val bookRepository: BookRepository): ViewModel() {

    fun getBooks() = bookRepository.getBooks()

    companion object {
        val Factory = viewModelFactory {
            initializer {

                //aca se crea esta variable para mandar a llamar al repository de books
                // porque el BooksViewModel lo requiere pero sin la variable creada no se puede accecder a el
                val booksRepository = (this[APPLICATION_KEY] as BookTrackerApplication).booksRepository
                BooksViewModel(booksRepository)
            }
        }
    }
}