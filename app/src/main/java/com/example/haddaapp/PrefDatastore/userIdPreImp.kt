package com.example.haddaapp.PrefDatastore


import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class userIdPreImp(val dataStore: DataStore<Preferences>) : userIdPref {
    override suspend fun SetupData(userID: String) {
        dataStore.edit {
            it[USER_KEY] = userID
        }
    }

    override fun GetData(): Flow<String> {
        return dataStore!!.data!!.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_KEY] ?: ""
        }
    }
}




