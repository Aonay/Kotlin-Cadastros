package br.edu.fatecpg.atividadepratica2

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.atividadepratica2.dao.ImcDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExibirImc : AppCompatActivity(R.layout.activity_exibir_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txvResultado = findViewById<TextView>(R.id.txv_resultadoIMC)
        val txvMensagem = findViewById<TextView>(R.id.txv_mensagem)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_fecharImc)

        val objetoImc = ImcDao.exibirResultado()
        txvResultado.text = "%.2f".format(objetoImc.resultado)

        val mensagem = when{
            objetoImc.resultado < 16.0 -> "Magreza Grave!"
            objetoImc.resultado in 16.0..16.9 -> "Magreza Moderada!"
            objetoImc.resultado in 17.0..18.5 -> "Magreza Leve!"
            objetoImc.resultado in 18.6..24.9 -> "Peso Ideal!"
            objetoImc.resultado in 25.0..29.9 -> "Sobrepeso!"
            objetoImc.resultado in 30.0..34.9 -> "Obesidade Grau I!"
            objetoImc.resultado in 35.0..39.9 -> "Obesidade Grau II ou Severa!"
            objetoImc.resultado >=46.0 -> "Obesidade Grau III ou Morbida!"

            else -> "Erro Inesperado"
        }

        txvMensagem.text = mensagem

        fabVoltar.setOnClickListener {
            finish()
        }



    }
}