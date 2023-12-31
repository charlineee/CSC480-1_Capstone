package com.example.npsapp.viewmodels

import android.provider.MediaStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.npsapp.models.Images
import com.example.npsapp.repositories.ParksRepository
import com.example.npsapp.util.Constants.activityMap
import com.example.npsapp.util.Constants.statesMap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    val repository: ParksRepository
): ViewModel() {
    private val _uiState : MutableStateFlow<ParksUIState> = MutableStateFlow(ParksUIState.Loading)
    val uiState : StateFlow<ParksUIState> = _uiState

    private fun loadResources(stateCode: String, activityCode: String){
        viewModelScope.launch {
            repository.getParksData(stateCode, activityCode)
                .onStart{
                    _uiState.value = ParksUIState.Loading
                }.catch {
                    _uiState.value = ParksUIState.Error(it)
                }.collect {
                    _uiState.value = it
                }
        }

    }

    fun getCodes(stateQuery: String, activityQuery: String){
        val stateCode = statesMap.getValue(stateQuery)
        val activityCode = activityMap.getValue(activityQuery)
        loadResources(stateCode, activityCode)
    }
}

data class ParksViewState(
    val name: String?,
    val fullName: String?,
    val id: String?,
    val description: String?,
    val url: String?,
    val images: List<Images>
) {
    companion object {
        val empty = ParksViewState(
            name = "",
            fullName = "",
            id = "",
            url = "",
            description = "",
            images = emptyList()
        )
    }
}

sealed class ParksUIState {
    class Success(val data: List<ParksViewState>?) : ParksUIState()
    class Error(val msg: Throwable) : ParksUIState()
    object Loading: ParksUIState()
}
