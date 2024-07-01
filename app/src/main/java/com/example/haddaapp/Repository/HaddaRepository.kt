package com.example.haddaapp.Repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.haddaapp.Models.MyOrderResponse
import com.example.haddaapp.Models.ProductResponse
import com.example.haddaapp.Models.UserProfile
import com.example.haddaapp.PrefDatastore.userIdPreImp
import com.example.haddaapp.Retrofit.ApiProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HaddaRepository(val datastore: DataStore<Preferences>, private  val context: Context) {

    //My Order List
   private val MutableOrderList = MutableStateFlow<List<MyOrderResponse>>(emptyList())
    val orderList: StateFlow<List<MyOrderResponse>>
        get() = MutableOrderList
    suspend fun MyAllOrder(id: String) {
        val response = ApiProvider.getInstance().MyOrder(id)
        if (response.isSuccessful && response.body() != null) {
            MutableOrderList.emit(response.body()!!)
        }
    }

    //Place Order
    suspend fun PlaceOrder(
        id: String,
        name: String,
        email: String,
        phoneNo: String,
        category: String,
        unit: Int,
        price: Double,
        address: String,
    ) {
        var response = ApiProvider.getInstance()
            .placeOrder(id, name, email, phoneNo, category, unit, price, address)
        if (response.isSuccessful && response.body() != null) {
            Log.d("Place Order", "All Items Order")
        }
    }

    //UserInfo
    private val UserProfileMutable = MutableStateFlow<UserProfile>(
        UserProfile(
            "Loading",
            "Loading",
            0,
            "Loading",
            "Loading",
            "Loading",
            "Loading"
        )
    )
    val UserProfile: StateFlow<UserProfile>
        get() = UserProfileMutable

    //Logout
    suspend fun LogOut() {
        setId("")
    }

    suspend fun GetProfile(userID: String) {
        var response = ApiProvider.getInstance().getUserInfo(userID)
        if (response.isSuccessful && response.body() != null) {
            UserProfileMutable.emit(response.body()!!)
        } else {

        }
    }

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
        if (response.isSuccessful && response.body() != null) {
            if (response!!.body()!!.success == 200) {
                setId(response.body()!!.message)
                Toast.makeText(context, "${response.body()!!.message}", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "${response.body()!!.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Register Api Connection
    suspend fun RegisterUser(
        name: String,
        email: String,
        phoneNo: String,
        address: String,
        password: String,
    ) {
        val response =
            ApiProvider.getInstance().RegisterApi(name, email, phoneNo, address, password)
        if (response.isSuccessful && response.body() != null) {
            if (response!!.body()!!.success == 200) {
                Toast.makeText(context, "${response.body()!!.message}", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "${response.body()!!.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val ProductListMutable = MutableStateFlow<List<ProductResponse>>(emptyList())
    val ProductList: StateFlow<List<ProductResponse>>
        get() = ProductListMutable

    suspend fun getProduct() {
        val response = ApiProvider.getInstance().GetProducts()
        if (response.isSuccessful && response.body() != null) {
            Log.d("VisRepoPRo", "${response.body()}")
            ProductListMutable.emit(response.body()!!)
        }
    }

}