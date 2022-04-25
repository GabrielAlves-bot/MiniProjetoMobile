package br.com.trabalho_final

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("My Trip - Home")

        val sharedPreference: SharedPreference = SharedPreference(this)
        var origem = findViewById<EditText>(R.id.origem)
        var destino = findViewById<EditText>(R.id.destino)
        var data = findViewById<EditText>(R.id.data)
        data.setInputType(InputType.TYPE_NULL)
        var button = findViewById<Button>(R.id.cadastrar)
        var checkbox = findViewById<CheckBox>(R.id.memorizar)
        var btnSugestao = findViewById<Button>(R.id.btnSugestao)
        origem.setText(sharedPreference.find("origem"))
        destino.setText(sharedPreference.find("destino"))
        data.setText(sharedPreference.find("data"))

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        data.setOnClickListener {
            var dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    val mmMonth = mMonth + 1
                    val date = "$mDay/$mmMonth/$mYear"
                    data.setText(date)
                },
                year,
                month,
                day
            )
            dpd.show()
        }

            //Repassa os valores do formulário para uma intent com os serviços.
            button.setOnClickListener {
                if(!origem.text.isEmpty() && !destino.text.isEmpty() && !data.text.isEmpty()) {
                val it: Intent = Intent(this, ViagemService::class.java)
                it.putExtra("origem", origem.text.toString())
                it.putExtra("destino", destino.text.toString())
                it.putExtra("data", data.text.toString())
                    startActivity(it)
                }else
                    Toast.makeText(applicationContext, "Preencha os campos", Toast.LENGTH_LONG).show()
                }



        btnSugestao.setOnClickListener {
            if(!origem.text.isEmpty()) {
                val it: Intent = Intent(this, Activity_sugestao_viagem::class.java)
                startActivity(it)
            }else
                Toast.makeText(applicationContext, "Preencha o campo Origem Para Continuar", Toast.LENGTH_LONG).show()
        }

        //Verifica se a checkbox está marcada e salva no SharedPreference
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sharedPreference.save("origem", "${origem.text}")
                sharedPreference.save("destino", "${destino.text}")
                sharedPreference.save("data", "${data.text}")
            }
        }
    }

}

