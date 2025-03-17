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
import br.edu.fatecpg.atividadepratica2.dao.ImcDao
import br.edu.fatecpg.atividadepratica2.dao.LivroDao
import br.edu.fatecpg.atividadepratica2.model.Imc
import br.edu.fatecpg.atividadepratica2.model.Livro
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CalcularImc : AppCompatActivity(R.layout.activity_calcular_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtAltura = findViewById<EditText>(R.id.edt_altura)
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val btnCalcularImc = findViewById<Button>(R.id.btn_calcImc)
        val fabSair = findViewById<FloatingActionButton>(R.id.fab_voltarImc)

        btnCalcularImc.setOnClickListener {
            val altura = edtAltura.text.toString()
            val altcalc = edtAltura.text.toString().toDouble()
            val peso = edtPeso.text.toString()
            val pescalc = edtPeso.text.toString().toDouble()
            val resultado = ImcDao.calcularImc(altcalc,pescalc)

            if(altura.isNotBlank() && peso.isNotBlank()){
                val imc = Imc(
                    altura = altura,
                    peso = peso,
                    resultado = resultado
                )
                ImcDao.gravarImc(imc)

                val intent = Intent(this,ExibirImc::class.java)
                startActivity(intent)
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Todos os campos devem ser preenchidos")
                val dialog = builder.create()
                dialog.show()
            }
        }

        fabSair.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}