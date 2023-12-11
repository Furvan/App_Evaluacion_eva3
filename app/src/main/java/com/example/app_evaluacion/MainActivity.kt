package com.example.app_evaluacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app_evaluacion.databinding.ActivityMainBinding
import com.example.app_evaluacion.vistas.ConexionFragment
import com.example.app_evaluacion.vistas.HistorialFragment
import com.example.app_evaluacion.vistas.HomeFragment
import com.example.app_evaluacion.vistas.InformacionFragment
import com.example.app_evaluacion.vistas.LogInFragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Si no se a seleccionado una vista mostrar una predeterminada */
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, HomeFragment()).commit()
        }

        /* Opciones para poder cambiar vistas en la barra del menu */
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.iHome -> {
                    supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, HomeFragment()).commit()
                    true
                }
                R.id.iLogIn -> {
                    supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, LogInFragment()).commit()
                    true
                }
                R.id.iConexion -> {
                    supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, ConexionFragment()).commit()
                    true
                }
                R.id.iHistorial -> {
                    supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, HistorialFragment()).commit()
                    true
                }
                R.id.iInfo -> {
                    supportFragmentManager.beginTransaction().replace(R.id.RelativeLayout, InformacionFragment()).commit()
                    true
                }

                else -> false
            }
        }

        /* Aviso de que ya te encuntras en la vista seleccionada */
        binding.bottomNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.iHome -> Toast.makeText(this, "Ya estas en la vista 'Inicio'", Toast.LENGTH_SHORT).show()
                R.id.iLogIn -> Toast.makeText(this, "Ya estas en la vista 'Iniciar sesion'", Toast.LENGTH_SHORT).show()
                R.id.iConexion -> Toast.makeText(this, "Ya estas en la vista 'Conexion'", Toast.LENGTH_SHORT).show()
                R.id.iHistorial -> Toast.makeText(this, "Ya estas en la vista 'Historial'", Toast.LENGTH_SHORT).show()
                R.id.iInfo -> Toast.makeText(this, "Ya estas en la vista 'Informacion'", Toast.LENGTH_SHORT).show()
                else -> false
            }
        }
    }
}

