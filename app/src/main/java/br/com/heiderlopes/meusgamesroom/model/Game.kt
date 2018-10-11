package br.com.heiderlopes.meusgamesroom.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

//A anotacao @Entity abaixo indica indica que
// a classe sera uma tabela SQL
@Entity
data class Game(
        //A anotacao PrimaryKey indica que a variável id será chave primária
        //da nossa base dados e ativamos o autoGenerate para que o id
        //seja gerado automaticamente
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        var nome: String? = null,
        @ForeignKey(entity = Genero::class, parentColumns = ["id"], childColumns = ["generoId"])
        var generoId: Int = 0
        //@Embedded val genero: Genero
        /*@ForeignKey(entity = Genero::class, parentColumns = ["id"], childColumns = ["generoId"])
        var generoId: Int = 0*/)