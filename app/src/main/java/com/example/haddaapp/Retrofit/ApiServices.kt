package com.example.haddaapp.Retrofit

import com.example.haddaapp.Models.MyOrderResponse
import com.example.haddaapp.Models.PlaceOrderResponse
import com.example.haddaapp.Models.ProductResponse
import com.example.haddaapp.Models.UserProfile
import com.example.haddaapp.Models.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://kanvarpal5.pythonanywhere.com"

interface ApiServices {


    @FormUrlEncoded
    @POST("/orders")
    suspend fun MyOrder(
        @Field("user_id") id:String
    ):Response<List<MyOrderResponse>>

    @FormUrlEncoded
    @POST("/OrderItems")
    suspend fun placeOrder(
        @Field("userID") id: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phoneNo") phoneNo: String,
        @Field("category") category: String,
        @Field("unit") unit:Int,
        @Field("price") price: Double,
        @Field("address") Address: String,
    ):Response<PlaceOrderResponse>

    @FormUrlEncoded
    @POST("/GetUser")
    suspend fun getUserInfo(@Field("userId") UserID: String): Response<UserProfile>

    @GET("/getAllProduct")
    suspend fun GetProducts(): Response<List<ProductResponse>>

    @FormUrlEncoded
    @POST("/loginUser")
    suspend fun LoginApi(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<UserResponse>

    @FormUrlEncoded
    @POST("/createUser")
    suspend fun RegisterApi(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phoneNo") phoneNo: String,
        @Field("address") address: String,
        @Field("password") password: String,
    ): Response<UserResponse>

}

object ApiProvider {
    private var INSTANCE: ApiServices? = null
    fun getInstance(): ApiServices {
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(ApiServices::class.java)
            }
        }
        return INSTANCE!!
    }
}

