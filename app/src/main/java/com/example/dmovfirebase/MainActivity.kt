package com.example.dmovfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

//https://proyectomoviles-c7e0e-default-rtdb.firebaseio.com/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

      //  myRef.child("ejemplo").child("1").setValue(Card("1", "rojo", "corazones"))
      //  myRef.child("ejemplo").child("2").setValue(Card("2", "negro", "trebol"))
      //  myRef.child("ejemplo").child("3").setValue(Card("3", "rojo", "diamantes"))

        myRef.child("usuarios").child("1").setValue(User("01", "Fulano", "Fulanés", "ful@email.com"))
        myRef.child("usuarios").child("2").setValue(User("02", "Mengano", "Menganés", "men@email.com"))
        myRef.child("usuarios").child("3").setValue(User("03", "Sutano", "Sutanés", "sut@email.com"))

        myRef.child("ejemplo").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.d("firebaseResponse", "Error getting data", it)
        }


    }
}