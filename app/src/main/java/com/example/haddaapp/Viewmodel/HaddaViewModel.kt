package com.example.haddaapp.Viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.ViewModel
import com.example.haddaapp.Models.Products
import com.example.haddaapp.Repository.HaddaRepository
import kotlinx.coroutines.flow.Flow

class HaddaViewModel(val context: Context):ViewModel() {
    val productList = mutableStateOf(mutableListOf<Products>())
    val datastore = PreferenceDataStoreFactory.create (
        corruptionHandler = ReplaceFileCorruptionHandler (produceNewData = { emptyPreferences() }),
        produceFile = {context.preferencesDataStoreFile("userPref")}
    )
    val repository = HaddaRepository(datastore)

    fun getId(): Flow<String> {
        return repository.getId()
    }

}