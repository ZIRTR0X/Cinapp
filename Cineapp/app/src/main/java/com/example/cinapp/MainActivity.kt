package com.example.cinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cinapp.model.Movie
import com.example.cinapp.navigation.MainScreen


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContent {
            MaterialTheme { MainScreen() }
        }
        /*
        // TextView
        val textView = findViewById<TextView>(R.id.text)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/search/tv?api_key=e53e59cf1e29b9afff93d9ca1208f0cf&query=One%20Piece&language=fr"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(url,
            { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            { error: VolleyError ->
                textView.text = "That didn't work!"
            }
        )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)


        //bottom navigation with jetpack compose

        */




    }
}