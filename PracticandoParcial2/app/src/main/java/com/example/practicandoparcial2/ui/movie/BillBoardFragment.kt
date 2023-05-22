package com.example.practicandoparcial2.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.practicandoparcial2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillBoardFragment : Fragment() {

    private lateinit var buttonBilBoardFragment: CardView
    private lateinit var actionToNew: FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBilBoardFragment = view.findViewById(R.id.btn_billBoard_action_to_movie)
        actionToNew = view.findViewById(R.id.btn_action_to_new_movie)

        buttonBilBoardFragment.setOnClickListener {
           it.findNavController().navigate(R.id.action_billBoardFragment_to_movieFragment)
        }

        actionToNew.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }
}