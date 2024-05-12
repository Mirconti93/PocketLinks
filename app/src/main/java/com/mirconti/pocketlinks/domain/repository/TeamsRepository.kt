package com.mircontapp.sportalbum.domain.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.LinkModel

interface TeamsRepository {
    suspend fun getAllTeams(): List<LinkModel>
    suspend fun addTeam(LinkModel: LinkModel)
    suspend fun teamsFromArea(area: Enums.Area) : List<LinkModel>
    suspend fun teamsFromSuperlega() : List<LinkModel>
    suspend fun getNationalTeams() : List<LinkModel>
    suspend fun insertTeam(linkModel: LinkModel)
    suspend fun updateTeam(linkModel: LinkModel)
}