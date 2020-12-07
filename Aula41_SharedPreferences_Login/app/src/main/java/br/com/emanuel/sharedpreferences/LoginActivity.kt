package br.com.emanuel.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class LoginActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val prefs = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

        val checkKeepConnected = findViewById<CheckBox>(R.id.checkKeepConnected)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            prefs.edit().putBoolean(NOTIFICATION_PREFS, checkKeepConnected.isChecked).apply()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    companion object {
        const val APP_NAME = "Aula40_Prefs"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }

}