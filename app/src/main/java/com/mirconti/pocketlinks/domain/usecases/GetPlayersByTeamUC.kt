package com.mircontapp.sportalbum.domain.usecases

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.PlayersRepository
import javax.inject.Inject
class GetPlayersByTeamUC @Inject constructor(val playersRepository: PlayersRepository) {
    suspend fun getPlayers(linkModel: LinkModel): List<CategoryModel> {
        return when (linkModel.area) {
            Enums.Area.NAZIONALI -> playersRepository.playersFromNational(linkModel.name, Enums.Gender.M)
            Enums.Area.NAZIONALIFEMMINILI-> playersRepository.playersFromNational(linkModel.name, Enums.Gender.F)
            else -> playersRepository.playersFromTeam(linkModel.name)
        }
    }
}