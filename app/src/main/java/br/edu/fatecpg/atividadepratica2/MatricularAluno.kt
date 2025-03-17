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
import br.edu.fatecpg.atividadepratica2.dao.AlunoDao
import br.edu.fatecpg.atividadepratica2.dao.LivroDao
import br.edu.fatecpg.atividadepratica2.model.Aluno
import br.edu.fatecpg.atividadepratica2.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MatricularAluno : AppCompatActivity(R.layout.activity_matricular_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val btnMatricular = findViewById<Button>(R.id.btn_matricular)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_sairAluno)

        btnMatricular.setOnClickListener {
            val nome = edtNome.text.toString()

            if(nome.isNotBlank()){
                val aluno = Aluno(nome)
                AlunoDao.matricularAluno(aluno)
                val intent = Intent(this,ExibirMatricula::class.java)
                startActivity(intent)
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("O campo nome deve estar preenchido")
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