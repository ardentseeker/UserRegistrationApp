package com.example.userregistrationapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userregistrationapp.R
import com.example.userregistrationapp.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    val database:FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRefrence : DatabaseReference = database.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        supportActionBar?.title = "Add User"

        mainBinding.floatingActionButton3.setOnClickListener {
            val intent = Intent(applicationContext,AddUser::class.java)
            startActivity(intent)
        }
    }
}