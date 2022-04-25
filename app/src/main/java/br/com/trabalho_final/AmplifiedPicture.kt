package br.com.trabalho_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AmplifiedPicture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amplified_picture)
        val image = findViewById<ImageView>(R.id.idImage)

        when (intent.getIntExtra("position", -1)) {
            0 -> {
                image.setImageResource(R.drawable.casa1)
            }
            1 -> {
                image.setImageResource(R.drawable.casa2)
            }
            2 -> {
                image.setImageResource(R.drawable.casa3)
            }
            3 -> {
                image.setImageResource(R.drawable.casa4)
            }
            4 -> {
                image.setImageResource(R.drawable.casa5)
            }
            5 -> {
                image.setImageResource(R.drawable.casa6)
            }
        }
    }
}