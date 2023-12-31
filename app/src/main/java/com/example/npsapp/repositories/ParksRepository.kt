package com.example.npsapp.repositories

import com.example.npsapp.data.ApiService
import com.example.npsapp.models.ParksResponse
import com.example.npsapp.util.Constants.API_KEY
import com.example.npsapp.viewmodels.ParksUIState
import com.example.npsapp.viewmodels.ParksViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ParksRepository @Inject constructor(
    private val apiService: ApiService,
) {
    fun getParksData(
        stateCode: String,
        activityCode: String
    ): Flow<ParksUIState> = flow {
        try {
            val result = apiService.getParks(stateCode, activityCode, API_KEY)
            emit(
                toUiModel(
                    result
                )
            )
        } catch (throwable: Throwable) {
            emit(ParksUIState.Error(throwable))
        }
    }
}

fun toUiModel(response: ParksResponse) : ParksUIState =
    ParksUIState.Success(response.data?.map { park ->
        ParksViewState(
            name = park.name,
            fullName = park.fullName,
            id = park.id,
            url = park.url,
            description = park.description,
            images = park.images
        )
    })
