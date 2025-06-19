package com.example.mymusicapp


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    // Parallel arrays
    val songTitles = ArrayList<String>()
    val artistNames = ArrayList<String>()
    val ratings = ArrayList<String>()
    val comments = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val nextButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            try {
                val song = findViewById<EditText>(R.id.SongeditTextText).text.toString()
                val artist = findViewById<EditText>(R.id.ArtisteditTextText).text.toString()
                val rating = findViewById<EditText>(R.id.RatingeditTextText).text.toString().toInt()
                val comment = findViewById<EditText>(R.id.CommenteditTextText).text.toString()

                if (rating in 1..5 && song.isNotEmpty() && artist.isNotEmpty()) {
                    songTitles.add(song)
                    artistNames.add(artist)
                    ratings.add(rating.toString())
                    comments.add(comment)
                    Toast.makeText(this , "Song Added!" , Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this , "Enter Valid details bro!" , Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this , "Error: ${e.message}" , Toast.LENGTH_SHORT).show()
            }
        }

        nextButton.setOnClickListener {
            val intent = Intent(this , PlaylistActivity::class.java)
            intent.putStringArrayListExtra("songs" , songTitles)
            intent.putStringArrayListExtra("artists" , artistNames)
            intent.putStringArrayListExtra("ratings" , ArrayList(ratings))
            intent.putStringArrayListExtra("comments" , comments)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }

        }
                }







