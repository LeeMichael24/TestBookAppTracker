package com.example.estudiando_para_parcial_mobiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.estudiando_para_parcial_mobiles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //utilizamos setContentView para inflar el layout de nuestra
        // actividad y así poder mostrarlo en pantalla activando data binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}