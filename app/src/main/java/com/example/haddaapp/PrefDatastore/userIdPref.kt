package com.example.haddaapp.PrefDatastore

import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
var USER_KEY = stringPreferencesKey("user_id")
interface userIdPref {
    suspend fun SetupData(userID:String)
    fun  GetData(): Flow<String>
}