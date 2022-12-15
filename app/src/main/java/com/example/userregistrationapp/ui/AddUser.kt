package com.example.userregistrationapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userregistrationapp.R
import com.example.userregistrationapp.databinding.ActivityAddUserBinding
import com.example.userregistrationapp.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddUser : AppCompatActivity() {

    lateinit var addUserBinding: ActivityAddUserBinding

    val database:FirebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference:DatabaseReference = database.reference.child("users")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        addUserBinding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = addUserBinding.root
        setContentView(view)

        addUserBinding.add.setOnClickListener {
            addUserData()
        }
    }

    fun addUserData(){

        val name = addUserBinding.nameAdd.text.toString()
        val email = addUserBinding.emailAdd.text.toString()
        val age = addUserBinding.ageAdd.text.toString().toInt()

        val id:String = databaseReference.push().key.toString()
        val user = User(id,name,email,age)
        databaseReference.child("id").setValue(user).addOnCompleteListener { task ->

            if (task.isSuccessful){
                Toast.makeText(applicationContext,"new usedr has been added",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(applicationContext,task.exception.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }




}