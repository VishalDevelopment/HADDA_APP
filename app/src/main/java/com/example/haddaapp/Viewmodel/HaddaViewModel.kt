package com.example.haddaapp.Viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haddaapp.Models.ProductResponse
import com.example.haddaapp.Models.UserProfile
import com.example.haddaapp.Repository.HaddaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HaddaViewModel(val context: Context) : ViewModel() {
    val datastore =
        PreferenceDataStoreFactory.create(corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }),
            produceFile = { context.preferencesDataStoreFile("userPref") })
    val repository = HaddaRepository(datastore,context)
    fun getId(): Flow<String> {
        return repository.getId()
    }

    //ProductList Show in Home Screen
    val ProductList: StateFlow<List<ProductResponse>> = repository.ProductList

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }

    val MyOrderList = repository.orderList
    //My OrderList
    fun getAllOrder(id:String){
        viewModelScope.launch {
            repository.MyAllOrder(id)
        }
    }
    // Place Order Screen
    val OrderProductList= mutableStateOf(mutableListOf<ProductResponse>())
    fun placeOrder(userid:String,name:String,email: String,phoneNo: String,category:String,unit:Int,price:Double,address: String){
     viewModelScope.launch {
         repository.PlaceOrder(userid, name, email, phoneNo, category,unit, price, address)
     }
    }
    //LogOut
    fun LogOut(){
        viewModelScope.launch{ repository.LogOut() }
    }

    //Profile Screen
    val UserInfo: StateFlow<UserProfile> = repository.UserProfile
    fun  getUserInfo(ID:String){
        viewModelScope.launch{
            repository.GetProfile(ID)
        }
    }
// Register Screen
    fun Register(
        name: String,
        email: String,
        phoneNo: String,
        address: String,
        password: String,
    ) {
        viewModelScope.launch {
            repository.RegisterUser(name, email, phoneNo, address, password)
        }
    }
// Login Screen
    fun Login(email: String, password: String) {
        viewModelScope.launch {
            repository.LoginUser(email, password)
        }
    }


}