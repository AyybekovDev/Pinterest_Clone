package com.example.pinterestclone.data.remote


import com.example.pinterestclone.model.Home
import com.example.pinterestclone.model.HomeItem
import com.example.pinterestclone.model.search.OnePeople
import com.example.pinterestclone.model.search.search1pagej.SeachImage
import com.example.pinterestclone.model.search.yangisi.SearchResp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    fun listPhotos1(
        @Query("page") page: Int,
        @Query("client_id") client_id:String="rSqXKqR6TpdYIhRIFdFEo913HU7_1tUSnnblDIXwE9E"
    ): Call<ArrayList<HomeItem>>
    @GET("photos/{id}")
    fun getImageById(
        @Path("id") id:String,
        @Query("client_id") client_id:String="rSqXKqR6TpdYIhRIFdFEo913HU7_1tUSnnblDIXwE9E",
    ):Call<OnePeople>
    @GET("search/photos")
    fun searchImages(
        @Query("query")query: String,
        @Query("client_id") client_id:String="rSqXKqR6TpdYIhRIFdFEo913HU7_1tUSnnblDIXwE9E"
    ):Call<SearchResp>
}