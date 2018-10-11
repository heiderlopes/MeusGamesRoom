package br.com.heiderlopes.meusgamesroom.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import br.com.heiderlopes.meusgamesroom.adapter.ItemCustomSpinner

@Entity
data class Genero(@PrimaryKey var id: Int = 0,
                  var genero: String = "") : ItemCustomSpinner {
    override val itemID: Any
        get() = id
    override val itemDescription: String
        get() = genero
}