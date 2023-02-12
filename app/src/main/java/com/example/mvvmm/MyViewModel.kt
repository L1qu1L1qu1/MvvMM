package com.example.mvvmm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(var repository:MyRepository):ViewModel() {
//    private val _gamesState = mutableStateListOf<List<Games>>(Response.Success(null))
//    val gamesState: State<Response<Games>> = _gamesState
    var mutableStateList = mutableStateListOf<String>()
    fun getUser(){
        viewModelScope.launch {
            repository.getUsers().collect{
                mutableStateList.add(it)
            }
        }
    }
}