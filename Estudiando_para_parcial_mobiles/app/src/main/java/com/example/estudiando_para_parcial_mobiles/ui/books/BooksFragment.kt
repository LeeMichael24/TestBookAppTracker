package com.example.estudiando_para_parcial_mobiles.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.estudiando_para_parcial_mobiles.R
import com.example.estudiando_para_parcial_mobiles.databinding.FragmentBooksBinding

//los que hace el by viewModels es que nos crea una instancia
// de la clase BooksViewModel y la guarda en el atributo viewModel
// para que la podamos utilizar en el fragment BooksFragment

//que significa by viewModels? significa que estamos delegando
// la creacion de la instancia de la clase BooksViewModel a la clase Fragment
class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //nosotros queremos devolver aca la view que se encuentra en el fragment_books.xml
        //entonces data binding nos permite hacer eso con el metodo inflate

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_books,
            container,
            false
        )
        //esto significa que muestra toda la view que se encuentra en fragment_books.xml
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BooksAdapter { book ->
            Toast.makeText(requireContext(), "Click en ${book.title}", Toast.LENGTH_LONG).show()
        }

        adapter.submitData(viewModel.getBooks())

        binding.recyclerViewBooks.adapter = adapter
    }
}