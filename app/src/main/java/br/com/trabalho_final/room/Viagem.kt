package br.com.trabalho_final.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Viagem")
data class Viagem(
    @PrimaryKey(autoGenerate = true)
    val idViagem:Int?,
    val cidadeViagem:String?,
    val descricaoViagem:String?,
    val tipoViagem:String?

)