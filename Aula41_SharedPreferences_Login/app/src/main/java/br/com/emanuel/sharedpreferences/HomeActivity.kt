package br.com.emanuel.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnBackToLogin = findViewById<Button>(R.id.btnBackToLogin)
        btnBackToLogin.setOnClickListener {

            val prefs = getSharedPreferences(LoginActivity.APP_NAME, Context.MODE_PRIVATE)
            prefs.edit().putBoolean(LoginActivity.NOTIFICATION_PREFS,false).apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}