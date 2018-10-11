package br.com.heiderlopes.meusgamesroom.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.heiderlopes.meusgamesroom.model.Game


@Database(entities = [Game::class], version = 1)
abstract class BancoDeDados : RoomDatabase() {

    abstract fun gameDAO(): GameDAO

    companion object {

        var INSTANCE: BancoDeDados? = null

        fun getDatabase(context: Context): BancoDeDados? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BancoDeDados::class.java,
                        "gamesdbs")
                        .build()
            }
            return INSTANCE
        }
    }

}
