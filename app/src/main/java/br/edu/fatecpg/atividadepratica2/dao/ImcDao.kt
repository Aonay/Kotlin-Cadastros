package br.edu.fatecpg.atividadepratica2.dao

import br.edu.fatecpg.atividadepratica2.model.Imc

class ImcDao {
    companion object{
        private var imc:Imc = Imc()

        fun gravarImc(entradas:Imc){
            imc = entradas
        }

        fun exibirResultado():Imc{
            return imc
        }

        fun calcularImc(altura:Double,peso:Double):Double {
            val item1 = altura*altura
            val resultado = peso/item1
            return resultado
        }
    }
}