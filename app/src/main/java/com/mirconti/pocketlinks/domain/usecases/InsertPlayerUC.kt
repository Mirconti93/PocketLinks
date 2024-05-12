package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.repository.PlayersRepository
import javax.inject.Inject

class InsertPlayerUC @Inject constructor(val playerRepository: PlayersRepository) {
    operator suspend fun invoke(categoryModel: CategoryModel) {
        playerRepository.insertPlayer(categoryModel)
    }
}