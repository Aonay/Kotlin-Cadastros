package br.edu.fatecpg.atividadepratica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.atividadepratica2.dao.AlunoDao
import br.edu.fatecpg.atividadepratica2.dao.LivroDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class ExibirMatricula : AppCompatActivity(R.layout.activity_exibir_matricula) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txvNome = findViewById<TextView>(R.id.txv_nome)
        val txvMatricula = findViewById<TextView>(R.id.txv_matricula)
        val btnGerarMatricula = findViewById<Button>(R.id.btn_gerarMatricula)
        val fabFechar = findViewById<FloatingActionButton>(R.id.fab_fecharMatricula)

        fun gerarMatricula(): String {
            val anoAtual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
            val numeroAleatorio = Random.nextInt(100000, 999999)
            return "$anoAtual$numeroAleatorio"
        }

        val objetoAluno = AlunoDao.exibirAluno()
        txvNome.text ="Nome: ${objetoAluno.nome}"

        btnGerarMatricula.setOnClickListener {
            val matricula = gerarMatricula()
            txvMatricula.text = "Matrícula: $matricula"

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("O numero de matricula foi gerado com sucesso")
            val dialog = builder.create()
            dialog.show()

        }


        fabFechar.setOnClickListener {
            val intent = Intent(this,MatricularAluno::class.java)
            startActivity(intent)
        }



    }
}