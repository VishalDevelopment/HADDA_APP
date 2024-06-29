package com.example.haddaapp.Repository

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import com.example.haddaapp.PrefDatastore.userIdPreImp
import com.example.haddaapp.PrefDatastore.userIdPref
import com.example.haddaapp.Retrofit.ApiProvider
import com.example.haddaapp.Retrofit.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class HaddaRepository(val datastore: DataStore<Preferences>) {
    //Setup UserId in Pref D.B
    suspend fun setId(userID: String) {
        userIdPreImp(datastore).SetupData(userID)
    }

 fun getId(): Flow<String> {
     return userIdPreImp(datastore).GetData()
 }
    // Login Api Connection
    suspend fun LoginUser(email: String, password: String) {
        var response = ApiProvider.getInstance().LoginApi(email, password)
        if (response.isSuccessful && response.body()!=null){
            setId(response.body()!!.message)
        }
        else{
            Log.d("Login","${response.body()!!.message}")
        }
    }
    

}