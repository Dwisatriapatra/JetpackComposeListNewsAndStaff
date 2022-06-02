package com.example.jetpackcomposelistingnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposelistingnews.model.GetAllNewsResponseItem
import com.example.jetpackcomposelistingnews.networking.ApiNewsServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(api: ApiNewsServices) : ViewModel() {
    private val newsState = MutableStateFlow(emptyList<GetAllNewsResponseItem>())
    val dataState: StateFlow<List<GetAllNewsResponseItem>> get() = newsState

    init {
        viewModelScope.launch {
            val dataNews = api.getAllUser()
            newsState.value = dataNews
        }
    }
}