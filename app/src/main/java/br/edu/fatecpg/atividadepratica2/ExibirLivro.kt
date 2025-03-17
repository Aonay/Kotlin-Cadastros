package br.edu.fatecpg.atividadepratica2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.atividadepratica2.dao.LivroDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExibirLivro : AppCompatActivity(R.layout.activity_exibir_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txvTitulo = findViewById<TextView>(R.id.txv_titulo)
        val txvAutor = findViewById<TextView>(R.id.txv_autor)
        val fabFechar = findViewById<FloatingActionButton>(R.id.fab_fecharLivro)

        val objetoLivro = LivroDao.retornarLivro()
        txvTitulo.text ="${objetoLivro.titulo}"
        txvAutor.text ="${objetoLivro.autor}"

        fabFechar.setOnClickListener {
            val intent = Intent(this,CadastrarLivro::class.java)
            startActivity(intent)
        }

    }
}