package com.joysoftgo.base_mvvm.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.joysoftgo.base_mvvm.domain.repository.DataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Single data store instance
 */
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DataStoreManager.dataStoreName)

@Singleton
class DataStoreManager @Inject constructor(
    @ApplicationContext val context: Context
) : DataStoreRepository {

    private val dataStore: DataStore<Preferences> by lazy {
        context.dataStore
    }

    companion object {
        const val dataStoreName = "hide_app_datastore"
        val keyPassword = stringPreferencesKey("KEY_PASSWORD")
    }

    override suspend fun savePassword(password: String) = dataStore.put(keyPassword, password)

    override suspend fun getPassword(): String = dataStore.get(keyPassword)

    private suspend fun <T> DataStore<Preferences>.put(key: Preferences.Key<T>, value: T) {
        edit { settings ->
            settings.putAll()
            settings[key] = value
        }
    }

    private suspend inline fun <reified T> DataStore<Preferences>.get(key: Preferences.Key<T>): T {
        return data.map { preferences ->
            preferences[key] ?: defaultValue()
        }.first()
    }

    /**
     * using Gson to parser Object to String
     */
    private inline fun <reified T> defaultValue(): T = when (T::class) {
        Boolean::class -> false as T
        Int::class -> 0 as T
        Long::class -> 0L as T
        Float::class -> 0f as T
        String::class -> "" as T
        Set::class -> mutableSetOf<String>() as T
        else -> throw IllegalStateException("Type value not support")
    }
}