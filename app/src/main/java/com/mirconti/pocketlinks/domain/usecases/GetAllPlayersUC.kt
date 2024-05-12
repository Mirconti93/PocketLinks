package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.repository.PlayersRepository
import javax.inject.Inject
class GetAllPlayersUC @Inject constructor(val playersRepository: PlayersRepository) {
    suspend fun getPlayers(): List<CategoryModel> {
        return playersRepository.getAllPlayers()
    }
}