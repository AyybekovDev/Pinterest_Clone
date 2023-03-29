package com.example.pinterestclone.data.remote
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiClient {
    private val isTester = true
    private val SERVER_DEVELOPMENT = "https://api.unsplash.com/"
    private val SERVER_PRODUCTION = "https://api.unsplash.com/"
    private val key = "client_id"
    private val keyValue = "rSqXKqR6TpdYIhRIFdFEo913HU7_1tUSnnblDIXwE9E"


    private val retrofit: Retrofit = Retrofit.Builder().
    baseUrl(baseUrl())
        .addConverterFactory(GsonConverterFactory.
        create()).client(getClient()).build()

    val apiService = retrofit.create(ApiService::class.java)


    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader(key, keyValue)
            chain.proceed(builder.build())
        })
            .build()
    }
    private fun baseUrl(): String {
        return if (isTester) SERVER_DEVELOPMENT
        else SERVER_PRODUCTION
    }
}