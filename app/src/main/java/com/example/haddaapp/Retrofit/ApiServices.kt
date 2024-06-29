package com.example.haddaapp.Retrofit

import com.example.haddaapp.Models.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

const val BASE_URL = ""

interface ApiServices {

    @FormUrlEncoded
    @POST("/loginUser")
    suspend fun LoginApi(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<LoginResponse>

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

