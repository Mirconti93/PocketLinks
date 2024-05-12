package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import javax.inject.Inject

class InsertTeamUC @Inject constructor(val teamsRepository: TeamsRepository) {
    operator suspend fun invoke(linkModel: LinkModel) {
        teamsRepository.insertTeam(linkModel)
    }
}