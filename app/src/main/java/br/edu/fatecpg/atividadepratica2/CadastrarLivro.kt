package br.edu.fatecpg.atividadepratica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.atividadepratica2.dao.LivroDao
import br.edu.fatecpg.atividadepratica2.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CadastrarLivro : AppCompatActivity(R.layout.activity_cadastrar_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrarLivro)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_sairLivro)

        btnCadastrar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val autor = edtAutor.text.toString()

            if(titulo.isNotBlank() && autor.isNotBlank()){
                val livro = Livro(
                    titulo = titulo,
                    autor = autor
                )
                LivroDao.cadastrarLivro(livro)
                val intent = Intent(this,ExibirLivro::class.java)
                startActivity(intent)
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Todos os campos devem ser preenchidos")
                val dialog = builder.create()
                dialog.show()
            }
        }

        fabVoltar.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}