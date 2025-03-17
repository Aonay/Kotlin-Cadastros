package br.edu.fatecpg.atividadepratica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val btnLivros = findViewById<Button>(R.id.btn_livros)
        val btnAlunos = findViewById<Button>(R.id.btn_alunos)
        val btnImc = findViewById<Button>(R.id.btn_imc)

        btnLivros.setOnClickListener {
            intent = Intent(this,CadastrarLivro::class.java)
            startActivity(intent)
        }

        btnAlunos.setOnClickListener {
            intent = Intent(this,MatricularAluno::class.java)
            startActivity(intent)
        }

        btnImc.setOnClickListener {
            intent = Intent(this,CalcularImc::class.java)
            startActivity(intent)
        }


    }
}