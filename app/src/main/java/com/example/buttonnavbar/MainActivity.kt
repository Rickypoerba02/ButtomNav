package com.example.buttonnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomAppBar)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId){
                R.id.btn_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                    R.id.btn_tambah -> {
                        Toast.makeText(this, "Uplaod image & video", Toast.LENGTH_SHORT).show()
                        true
                    }
                R.id.btn_simpan -> {
                    replaceFragment(SimpanFragment())
                    true
                }
                R.id.btn_akun -> {
                    replaceFragment(AkunFragment())
                    true
                }
                else -> false
            }

        }
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}