package br.edu.fatecpg.atividadepratica2.dao

import br.edu.fatecpg.atividadepratica2.model.Aluno

class AlunoDao {

    companion object{
        private var aluno:Aluno = Aluno()

        fun matricularAluno(dadosaluno:Aluno){
            aluno = dadosaluno
        }

        fun exibirAluno():Aluno{
            return aluno
        }
    }

}