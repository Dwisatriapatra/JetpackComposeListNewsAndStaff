package com.example.jetpackcomposelistingnews.networking

import com.example.jetpackcomposelistingnews.model.GetAllNewsResponseItem
import retrofit2.http.GET

interface ApiNewsServices {
    @GET("news")
    suspend fun getAllUser(): List<GetAllNewsResponseItem>
}