package com.example.mymusicapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.collections.sum

class PlaylistActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        // Retrieve arrays passed from MainActivity
        val songList = intent.getStringArrayListExtra("songs") ?: arrayListOf()
        val artistList = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratingsList = intent.getStringArrayListExtra("ratings") ?: arrayListOf()
        val commentList = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        // Link UI elements correctly
        val output = findViewById<TextView>(R.id.tvOutput)
        val avgButton = findViewById<Button>(R.id.btnAverage)
        val backButton = findViewById<Button>(R.id.btnBack)

        //Build and display the song list
        val builder = StringBuilder()
        for (i in songList.indices) {
            builder.append("Song: ${songList[i]}\n")
            builder.append("Artist: ${artistList[i]}\n")
            builder.append("Rating: ${ratingsList[i]}\n")
            builder.append("Comment: ${commentList[i]}\n\n")
        }
        output.text = builder.toString()


        // Show average rating
        avgButton.setOnClickListener {
            if (ratingsList.isNotEmpty()) {
                val avg = ratingsList.toList()sum() / ratingsList.size.toDouble()
                Toast.makeText(this , "Average Rating: %.2f".format(avg) , Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No ratings to calculate average.", Toast.LENGTH_SHORT).show()
            }
        }
        // Return to MainActivity
        backButton.setOnClickListener {
            finish()
        }



        }
        }






