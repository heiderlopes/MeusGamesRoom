package br.com.heiderlopes.meusgamesroom

import android.app.AlertDialog
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import br.com.heiderlopes.meusgamesroom.adapter.CustomSpinnerAdapter
import br.com.heiderlopes.meusgamesroom.dao.BancoDeDados
import br.com.heiderlopes.meusgamesroom.model.Game
import br.com.heiderlopes.meusgamesroom.model.Genero

class NovoGameDialog : DialogFragment() {

    private lateinit var builder: AlertDialog.Builder
    private lateinit var etGame: EditText
    private lateinit var spGenero: Spinner

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        builder = AlertDialog.Builder(activity)

        val v = activity?.layoutInflater?.inflate(R.layout.novo_game_dialog, null)!!

        etGame = v.findViewById(R.id.etGame)
        spGenero = v.findViewById(R.id.spGenero)

        builder.setView(v)
        builder.setTitle("Novo Game")
        builder.setPositiveButton("Adicionar") { _, _ ->
            val db = BancoDeDados.getDatabase(activity!!.applicationContext)
            val game = Game(null,
                    etGame.text.toString(),
                    1)
            if (game.nome != "")
                InsertAsyncTask(db!!).execute(game)
        }

        initGeneroSpinner(spGenero)
        builder.setNegativeButton("Cancelar", null)
        return builder.create()
    }

    private fun initGeneroSpinner(spinner: Spinner) {
        val generos = arrayListOf(Genero(1, "Esporte"),
                Genero(2, "Ação"), Genero(3, "RPG"))
        val customSpinnerAdapter = CustomSpinnerAdapter(context!!, generos)
        spinner.adapter = customSpinnerAdapter

        /*if(estado.id.equals("")) {
            spinner.setSelection(0)
        } else {
            spinner.setSelection(estados.indexOf(estado))
        }*/

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                //generoSelecionado = parent.getItemAtPosition(position) as Genero
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private inner class InsertAsyncTask internal constructor(appDatabase: BancoDeDados) : AsyncTask<Game, Void, String>() {
        private val db: BancoDeDados = appDatabase

        override fun doInBackground(vararg params: Game): String {
            db.gameDAO().inserir(params[0])
            return ""
        }
    }
}
