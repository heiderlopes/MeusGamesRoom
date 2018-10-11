package br.com.heiderlopes.meusgamesroom

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import br.com.heiderlopes.meusgamesroom.dao.BancoDeDados
import br.com.heiderlopes.meusgamesroom.model.Game

class ListaGameViewModel(application: Application) : AndroidViewModel(application) {

    private val bd: BancoDeDados = BancoDeDados.getDatabase(application.applicationContext)!!

    lateinit var games: LiveData<List<Game>>

    init {
        carregarDados()
    }

    private fun carregarDados() {
        //Carregar os dados da nossa Base de dados e armazenar no LiveData
        games = bd.gameDAO().lerGames()
    }
}
