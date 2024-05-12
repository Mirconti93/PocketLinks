package com.mircontapp.sportalbum.data.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.data.datasource.PocketDataSource
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import javax.inject.Inject
import kotlin.collections.ArrayList

class TeamsRepositoryImpl @Inject constructor(val pocketDataSource: PocketDataSource) : TeamsRepository {

    override suspend fun getAllTeams(): List<LinkModel> {
        return pocketDataSource.fetchCategories()?.toMutableList() ?: ArrayList()
    }

    override suspend fun addTeam(linkModel: LinkModel) {
        //teams.add(teamModel)
    }

    override suspend fun teamsFromArea(area: Enums.Area) : List<LinkModel> {
        return getAllTeams().filter { area.equals(it.area) }.sortedBy { it.name }
    }

    override suspend fun updateTeam(linkModel: LinkModel) {
        pocketDataSource.updateTeam(linkModel)
    }

    override suspend fun insertTeam(linkModel: LinkModel) {
        pocketDataSource.insertTeam(linkModel)
    }

    override suspend fun getNationalTeams(): List<LinkModel> {
        return getAllTeams().filter { "national".equals(it.type) }.sortedBy { it.name }
    }

    override suspend fun teamsFromSuperlega(): List<LinkModel> {
        return getAllTeams().filter { it.superlega ?: false }.sortedBy { it.name }
    }



}