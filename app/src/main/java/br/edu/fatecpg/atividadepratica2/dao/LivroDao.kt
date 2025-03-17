package br.edu.fatecpg.atividadepratica2.dao

import br.edu.fatecpg.atividadepratica2.model.Livro

class LivroDao {

    companion object{
        private var livro:Livro = Livro()

        fun cadastrarLivro(dadosrecebidos:Livro){
            livro = dadosrecebidos
        }

        fun retornarLivro():Livro{
            return livro
        }
    }
}