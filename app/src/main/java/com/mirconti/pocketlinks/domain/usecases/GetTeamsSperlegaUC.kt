package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import javax.inject.Inject

class GetTeamsSuperlegaUC @Inject constructor(val teamsRepository: TeamsRepository) {
    suspend fun getTeams(): List<LinkModel> {
        return teamsRepository.teamsFromSuperlega()
    }
}