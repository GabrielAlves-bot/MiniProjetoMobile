package br.com.trabalho_final

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.w3c.dom.Text

class ViagemService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viagem_service)
        setTitle("MyTrip - Service")

        var tv_origem = findViewById<TextView>(R.id.origemDigitada)
        var tv_destino = findViewById<TextView>(R.id.destinoDigitado)
        var tv_data = findViewById<TextView>(R.id.dataDigitada)
        val buttonApi = findViewById<Button>(R.id.buttonApi)
        val buttonMaps = findViewById<Button>(R.id.buttonMaps)

        var origemDigitada: String = intent.getStringExtra("origem").toString()
        var destinoDigitado: String = intent.getStringExtra("destino").toString()
        var dataDigitada: String = intent.getStringExtra("data").toString()

        tv_origem.text = origemDigitada
        tv_destino.text = destinoDigitado
        tv_data.text = dataDigitada

        buttonApi.setOnClickListener {
            //Método que repassa para a intent que faz requisição na API.
            getImoveisByDestino(destinoDigitado)
        }
        buttonMaps.setOnClickListener {
            //Método que repassa para a intent que faz requisição na API.
            getTravelDistance(origemDigitada, destinoDigitado)
        }
    }

    fun getImoveisByDestino(destino: String) {
        val it: Intent = Intent(this, ApiRequest::class.java)
        it.putExtra("destino", destino)
        startActivity(it)
    }

    fun getTravelDistance(origem: String, destino: String) {
        var url =
            Uri.parse("https://www.google.com/maps/dir/?api=1&origin={$origem}&destination={$destino}&travelmode=driving")
        val mapIntent = Intent(Intent.ACTION_VIEW, url)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}