package com.francisco.onepieceec03navarroinfante.views
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.francisco.onepieceec03navarroinfante.R
import com.francisco.onepieceec03navarroinfante.databinding.ActivityMainBinding
import com.francisco.onepieceec03navarroinfante.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences= getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE)
        Handler().postDelayed({
            val email: String = sharedPreferences.getString(LoginActivity.EMAIL, "" )?: ""
            val intent = if (email.isNotEmpty()){
                 Intent(this, MainActivity::class.java)
            }else {
                 Intent(this, LoginActivity::class.java)
            }

            startActivity(intent)
            finish()
        }, 2000)

    }
}