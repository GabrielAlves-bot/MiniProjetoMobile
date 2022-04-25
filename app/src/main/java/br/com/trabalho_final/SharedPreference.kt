package br.com.trabalho_final

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(mCtx: Context) {
    private val PREFERENCE_NAME = "sharedPreference"
    val sharedPreference: SharedPreferences = mCtx.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun save(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun find(key: String): String? {
        return sharedPreference.getString(key, "")
    }

    fun remove(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.remove(key)
        editor.commit()
    }
}