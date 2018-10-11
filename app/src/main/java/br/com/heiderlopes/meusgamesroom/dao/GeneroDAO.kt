package br.com.heiderlopes.meusgamesroom.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.heiderlopes.meusgamesroom.model.Genero

@Dao
interface GeneroDAO {

    @Insert
    fun inserir(genero: Genero)

    @Query("SELECT * FROM Genero")
    fun lerGeneros(): LiveData<List<Genero>>

    @Query("SELECT * FROM Genero WHERE id = :id")
    fun buscarPor(id: Int): Genero

    @Update
    fun atualizar(genero: Genero)

    @Delete
    fun apagar(genero: Genero)
}
