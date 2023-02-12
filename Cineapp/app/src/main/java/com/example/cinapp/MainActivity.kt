package com.example.cinapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.cinapp.data.persistance.MediaDatabase
import com.example.cinapp.databinding.ActivityMainBinding
import com.example.cinapp.ui.fragments.HomeFragment
import com.example.cinapp.ui.fragments.MovieFragment
import com.example.cinapp.ui.fragments.SearchFragment
import com.example.cinapp.ui.fragments.SerieFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment(this))
        supportActionBar?.hide()

        binding.bottomNavigation.setOnItemSelectedListener {
            var movie = MovieFragment()
            movie.main = this
            var serie = SerieFragment()
            serie.main = this

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment(this))
                R.id.movie -> replaceFragment(movie)
                R.id.serie -> replaceFragment(serie)
                R.id.search -> replaceFragment(SearchFragment(this))
                /*else -> false*/
            }
            true
        }
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_layout, fragment).commit()
    }
}