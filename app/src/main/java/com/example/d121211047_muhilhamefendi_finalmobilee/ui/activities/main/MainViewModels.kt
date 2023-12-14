package com.example.d121211047_muhilhamefendi_finalmobilee.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.d121211047_muhilhamefendi_finalmobilee.data.models.ListDoa
import com.example.d121211047_muhilhamefendi_finalmobilee.data.repository.DoaRepository
import com.example.d121211047_muhilhamefendi_finalmobilee.ui.MyDoaApp
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val doadoa: List<ListDoa>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModels(private val doaRepository: DoaRepository): ViewModel(){
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getDoa() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = doaRepository.getDoa()
            mainUiState = MainUiState.Success(result.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
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
                MainViewModels(doaRepository)
            }
        }
    }
}
