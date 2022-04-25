package br.com.trabalho_final.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ViagemDAO {
    @Insert
    suspend fun insert(viagem: Viagem)

    @Query("select * from Viagem")
     fun filterViagem():LiveData<List<Viagem>>
}