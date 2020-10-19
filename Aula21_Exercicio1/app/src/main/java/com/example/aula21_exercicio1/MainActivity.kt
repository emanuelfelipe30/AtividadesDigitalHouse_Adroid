package com.example.aula21_exercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        val fragmentA = MyFragmentA()
        val fragmentB = MyFragmentB()

        btnFragmentA.setOnClickListener{
            addFragment(fragmentA)
        }

        btnFragmentB.setOnClickListener{
            addFragment(fragmentB)
        }
    }

    private fun addFragment(fragment: Fragment){
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.placeHolder, fragment)
        transaction.commit()
    }
}