package com.example.d121211047_muhilhamefendi_finalmobilee.ui.activities.main

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.d121211047_muhilhamefendi_finalmobilee.data.models.ListDoa
import com.example.d121211047_muhilhamefendi_finalmobilee.data.repository.DoaRepository
import com.example.d121211047_muhilhamefendi_finalmobilee.ui.MyDoaApp
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

sealed interface MainUiState {
    data class Success(val doadoa: List<ListDoa>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModels(application: Application, private val doaRepository: DoaRepository): AndroidViewModel(application){
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getDoa() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
//        try {
//            val result = doaRepository.getDoa()
//            mainUiState = MainUiState.Success(result.orEmpty())
//        } catch (e: IOException) {
//            mainUiState = MainUiState.Error
//        }
        try {
            val jsonString = doaRepository.getDoa()
            println("Received JSON: $jsonString")

            if (jsonString.isNotEmpty()) {
                try {
                    val response = Json.decodeFromString<List<ListDoa>>(jsonString.toString())
                    mainUiState = MainUiState.Success(response)
                } catch (e: SerializationException) {
                    e.printStackTrace()
                    mainUiState = MainUiState.Error
                    println("Error during JSON parsing: ${e.message}")
                }
            } else {
                mainUiState = MainUiState.Error
                println("Empty JSON response")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            mainUiState = MainUiState.Error
            println("Error: ${e.message}")
        }
    }

    init {
        getDoa()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyDoaApp)
                val doaRepository = application.container.doaRepository
                MainViewModels(application, doaRepository)
            }
        }
    }
}