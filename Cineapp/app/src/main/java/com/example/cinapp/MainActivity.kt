package com.example.cinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cinapp.databinding.ActivityMainBinding
import com.example.cinapp.model.navigation.HomeFragment
import com.example.cinapp.model.navigation.MovieFragment
import com.example.cinapp.model.navigation.SearchFragment
import com.example.cinapp.model.navigation.SerieFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.movie -> replaceFragment(MovieFragment())
                R.id.serie -> replaceFragment(SerieFragment())
                R.id.search -> replaceFragment(SearchFragment())
                else -> false
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_layout, fragment).commit()
    }
}