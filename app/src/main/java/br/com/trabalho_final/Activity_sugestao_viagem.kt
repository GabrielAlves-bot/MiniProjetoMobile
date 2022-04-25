package br.com.trabalho_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.trabalho_final.room.Activity_listagem

class Activity_sugestao_viagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugestao_viagem)
        var btnAmigos=findViewById<Button>(R.id.btn_amigos)
        var btnLazer=findViewById<Button>(R.id.btn_lazer)
        var btnTrabalho=findViewById<Button>(R.id.btn_trabalho)


        btnAmigos.setOnClickListener {
            val it: Intent = Intent(this, Activity_listagem::class.java)

            startActivity(it)
        }

        btnLazer.setOnClickListener {
            val it: Intent = Intent(this, Activity_listagem::class.java)

            startActivity(it)
        }

        btnTrabalho.setOnClickListener {
            val it: Intent = Intent(this, Activity_listagem::class.java)
            startActivity(it)
        }

    }


}