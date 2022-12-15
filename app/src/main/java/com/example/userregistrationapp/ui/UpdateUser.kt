package com.example.userregistrationapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userregistrationapp.R
import com.example.userregistrationapp.databinding.ActivityAddUserBinding
import com.example.userregistrationapp.databinding.ActivityUpdateUserBinding

class UpdateUser : AppCompatActivity() {

    lateinit var updateUserBinding: ActivityUpdateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val view = updateUserBinding.root
        setContentView(view)
    }
}