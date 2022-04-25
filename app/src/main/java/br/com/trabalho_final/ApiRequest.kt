package br.com.trabalho_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class ApiRequest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_response)
        setTitle("My Trip - API Response")

        var destino: String = intent.getStringExtra("destino").toString()
        var local = findViewById<TextView>(R.id.local)

        val gson = Gson()
        var imv: Imovel

        val queue = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2:8080/imovel/getByCidade/$destino"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                imv = gson?.fromJson(response, Imovel::class.java)
                var listView = findViewById<ListView>(R.id.listView)
                var list = mutableListOf<Imovel>()
                list.add(Imovel(imv.preco, R.drawable.casa1, imv.cidade, imv.descricao))
                listView.adapter = MyAdapter(this, R.layout.row, list)

                listView.setOnItemClickListener { adapterView, view, position, id ->
                    val it: Intent = Intent(this, AmplifiedPicture::class.java)
                    it.putExtra("position", position)
                    startActivity(it)
                }
            },
            { error ->
                local.text = "ERROR: %s".format(error.toString())
            },
        )
        queue.add(stringRequest)
    }
}