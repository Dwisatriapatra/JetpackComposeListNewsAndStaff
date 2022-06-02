package com.example.jetpackcomposelistingnews.networking

import com.example.jetpackcomposelistingnews.model.GetAllStaffResponseItem
import retrofit2.http.GET

interface ApiStaffServices {
    @GET("staf")
    suspend fun getAllStaff(): List<GetAllStaffResponseItem>
}