package com.example.estudiando_para_parcial_mobiles.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.estudiando_para_parcial_mobiles.R
import com.example.estudiando_para_parcial_mobiles.data.Book
import com.example.estudiando_para_parcial_mobiles.data.books


//se extiende la clase del adaptador de RecycleView .Adapter este
//adapter necesita un viewHolder donde guardar el view que va a
// usar y asi estarlo recyclando una y otra vez para no estar teniendolo que crarlo de nuevo


class BooksAdapter( private val onClickBook: (Book) -> Unit): RecyclerView.Adapter <BooksAdapter.ViewHolderBook>(){


    //esta clase debe heredar de  RecycleView.ViewHolder y tiene como requisito que el padre
    // necesita recibir como parametro la view que va a reciclar entonces como no sabemos cual
    // es esa view aun, le agregamos un itemView en el constructor del viewHoldewr y cuando se
    // construya ese viewHolder alguien nos tendra que pasar la view
    //Por el momento manual porque no hay dataBinding
    private var books: List<Book>? = null


    class ViewHolderBook(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book, onClickBook: (Book) -> Unit) {
            val titleTextView = itemView.findViewById<TextView>(R.id.book_name)
            titleTextView.text = book.title
            titleTextView.setOnClickListener {
                onClickBook(book)
            }
        }
    }

        //cuando se necesitemos de crear el viewHolder significa que vamos
        //a crear una lista y la meteremos dentro del viewHolder para que sea reciclado
        //en el .from() le pasamos el contexto de una actidiad, un fragmento o de la aplicacion
        //pero como tenemos cerca el contexto se lo pasamos.
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater
                .inflate(
                    R.layout.item_book,
                    parent,
                    false
                )
            return ViewHolderBook(view)
        }

        //cuando nos pregunten cuantos items tiene nuestra la list vamos a retornar el tamaño de books
        //el operador elvis dice que si la lista esta vacia retornara la derecha osea 0 sino lel tamaño izquierda
        override fun getItemCount(): Int = books?.size ?: 0


        //aca retornaremos el dato que nos esta pidiendo con un viewHolder
        override fun onBindViewHolder(holder: ViewHolderBook, position: Int) {
            books?.let {
                holder.bind(it[position], onClickBook)
            }
        }

        //esta funcion nos permite actualizar la lista de libros y enviarlo a la clase del framento
        fun submitData(books: List<Book>) {
            this.books = books
            notifyDataSetChanged()
        }
}