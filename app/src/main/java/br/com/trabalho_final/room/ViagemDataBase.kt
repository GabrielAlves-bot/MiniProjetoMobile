package br.com.trabalho_final.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Viagem::class], version = 1, exportSchema = false)
abstract class ViagemDataBase : RoomDatabase() {

    abstract fun viagemDAO(): ViagemDAO

    companion object {
        @Volatile
        private var INSTANCE: ViagemDataBase? = null

        fun getDatabase(context: Context): ViagemDataBase {
            val tempInstanse = INSTANCE
            if (tempInstanse != null) {
                return tempInstanse
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ViagemDataBase::class.java,
                    "viagem_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}