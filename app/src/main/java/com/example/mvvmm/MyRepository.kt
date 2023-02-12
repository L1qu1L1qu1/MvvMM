package com.example.mvvmm

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MyRepository @Inject constructor() {
    fun getUsers(): Flow<String> = flow {
        val database = listOf("Tom", "Bob", "Sam")  // условная база данных
        var i = 1;
        for (item in database){
            delay(2000L) // имитация продолжительной работы
            println("Emit $i item")
            emit(item) // емитируем значение
            i++
        }
    }
}