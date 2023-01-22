package com.example.cinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.Fragment
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cinapp.databinding.ActivityMainBinding
import com.example.cinapp.model.Movie
import com.example.cinapp.navigation.MovieFragment
import com.example.cinapp.navigation.SearchFragment
import com.example.cinapp.navigation.SerieFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MovieFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.movie -> replaceFragment(MovieFragment())
                R.id.serie -> replaceFragment(SerieFragment())
                R.id.search -> replaceFragment(SearchFragment())
                else -> false
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }
}