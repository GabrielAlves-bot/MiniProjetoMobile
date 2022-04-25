package br.com.trabalho_final.room

import androidx.lifecycle.LiveData

class ViagemRepository(private val viagemDAO: ViagemDAO) {
    val filterViagem: LiveData<List<Viagem>> = viagemDAO.filterViagem()

    suspend fun addViagem(viagem: Viagem){
        viagemDAO.insert(viagem)
    }
}