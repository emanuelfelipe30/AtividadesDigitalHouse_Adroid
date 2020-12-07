package br.com.emanuel.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

const val SPLASH_DURATION = 3000L

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences(LoginActivity.APP_NAME, Context.MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(LoginActivity.NOTIFICATION_PREFS, false)

        val intent = if(prefsChecked) {
            Intent(this, HomeActivity::class.java)
        } else {
            Intent(this, LoginActivity::class.java)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        }, SPLASH_DURATION)

    }
}