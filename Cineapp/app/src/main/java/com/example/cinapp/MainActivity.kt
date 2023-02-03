package com.example.cinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.cinapp.databinding.ActivityMainBinding
import com.example.cinapp.fragments.HomeFragment
import com.example.cinapp.fragments.MovieFragment
import com.example.cinapp.fragments.SearchFragment
import com.example.cinapp.fragments.SerieFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        supportActionBar?.hide()

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.movie -> replaceFragment(MovieFragment())
                R.id.serie -> replaceFragment(SerieFragment())
                R.id.search -> replaceFragment(SearchFragment())
                /*else -> false*/
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_layout, fragment).commit()
    }
}