package com.example.app_evaluacion.crud

import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import com.google.firebase.database.FirebaseDatabase

class HumidityViewModel : ViewModel() {

    private val databaseRef: DatabaseReference = import androidx.lifecycle.ViewModel
            import com.google.firebase.database.*

    class HumidityViewModel : ViewModel() {

        private val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("humidity_data")

        fun agregarDatos(humidityData: HumidityData) {
            val nuevoElemento = databaseRef.push()
            nuevoElemento.setValue(humidityData)
        }

        fun obtenerDatos(callback: (List<HumidityData>) -> Unit) {
            databaseRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val datos = mutableListOf<HumidityData>()
                    for (childSnapshot in snapshot.children) {
                        val data = childSnapshot.getValue(HumidityData::class.java)
                        data?.let { datos.add(it) }
                    }
                    callback(datos)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Manejar error
                }
            })
        }

        fun actualizarDatos(key: String, humidityData: HumidityData) {
            databaseRef.child(key).setValue(humidityData)
        }

        fun eliminarDatos(key: String) {
            databaseRef.child(key).removeValue()
        }
    }
    FirebaseDatabase.getInstance().reference.child("humidity_data")

    fun agregarDatos(humidityData: HumidityData) {
        val nuevoElemento = databaseRef.push()
        nuevoElemento.setValue(humidityData)
    }

    fun obtenerDatos(callback: (List<HumidityData>) -> Unit) {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val datos = mutableListOf<HumidityData>()
                for (childSnapshot in snapshot.children) {
                    val data = childSnapshot.getValue(HumidityData::class.java)
                    data?.let { datos.add(it) }
                }
                callback(datos)
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejar error
            }
        })
    }

    fun actualizarDatos(key: String, humidityData: HumidityData) {
        databaseRef.child(key).setValue(humidityData)
    }

    fun eliminarDatos(key: String) {
        databaseRef.child(key).removeValue()
    }
}
