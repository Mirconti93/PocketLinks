package com.mircontapp.sportalbum.domain.usecases

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import javax.inject.Inject

class GetTeamsFromAreaUC @Inject constructor(val teamsRepository: TeamsRepository) {
    suspend fun getTeamsFromArea(area: Enums.Area): List<LinkModel> {
        return teamsRepository.teamsFromArea(area)
    }
}