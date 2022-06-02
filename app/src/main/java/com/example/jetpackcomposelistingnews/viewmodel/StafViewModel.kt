package com.example.jetpackcomposelistingnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposelistingnews.model.GetAllStaffResponseItem
import com.example.jetpackcomposelistingnews.networking.ApiStaffServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class StafViewModel @Inject constructor(@Named("staff") api: ApiStaffServices) : ViewModel() {
    private val staffState = MutableStateFlow(emptyList<GetAllStaffResponseItem>())
    val dataState: StateFlow<List<GetAllStaffResponseItem>> get() = staffState

    init {
        viewModelScope.launch {
            val dataStaff = api.getAllStaff()
            staffState.value = dataStaff
        }
    }
}