package br.com.trabalho_final.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViagemViewModel(application: Application):AndroidViewModel(application) {

    val filterViagem:LiveData<List<Viagem>>
    private val repository:ViagemRepository

    init {
        val viagemDAO = ViagemDataBase.getDatabase(application).viagemDAO()
        repository = ViagemRepository(viagemDAO)
        filterViagem = repository.filterViagem

    }

     fun addViagem(viagem: Viagem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addViagem(viagem)
        }
    }
}