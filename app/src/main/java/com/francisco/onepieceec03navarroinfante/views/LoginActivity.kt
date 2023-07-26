package com.francisco.onepieceec03navarroinfante.views

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.francisco.onepieceec03navarroinfante.R
import com.francisco.onepieceec03navarroinfante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

        private lateinit var binding: ActivityLoginBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
            setupViews()
        }

        private fun setupViews(){
            binding.tilEmail.editText?.addTextChangedListener{text ->
                binding.btnLogin.isEnabled = validateInputs(text.toString(), binding.tilPassword.editText?.text.toString())
            }
            binding.tilPassword.editText?.addTextChangedListener { text ->
                binding.btnLogin.isEnabled = validateInputs(binding.tilEmail.editText?.text.toString(), text.toString())
            }
            binding.btnLogin.setOnClickListener{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
                val email = binding.tilEmail.editText?.text.toString()
                val password = binding.tilPassword.editText?.text.toString()
                if (email == "ejemplo@idat.edu.pe" && password == "123456")
                    Toast.makeText(this,"Inicio de sesión correcto", Toast.LENGTH_SHORT).show()
                else{
                    Toast.makeText(this, "INCORRECTO", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun validateInputs(email:String , password:String): Boolean{
            val isEmailOk = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            val isPasswordOk = password.length >= 6
            return isPasswordOk && isEmailOk
        }
}