package com.mircontapp.sportalbum.data.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.data.datasource.PocketDataSource
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.repository.PlayersRepository


class PlayersRepositoryImpl(val pocketDataSource: PocketDataSource): PlayersRepository {

    override suspend fun getAllPlayers(): List<CategoryModel> {
        return pocketDataSource.fetchLinks()?.toList() ?: ArrayList()
    }

    override suspend fun playersFromTeam(teamName: String) : List<CategoryModel> {
        return getAllPlayers().filter { it.team.equals(teamName) }
    }

    override suspend fun playersFromTeamLegend(teamName: String): List<CategoryModel> {
        return getAllPlayers().filter { teamName.equals(it?.teamLegend) }
    }

    override suspend fun playersFromNational(country: String, gender: Enums.Gender): List<CategoryModel> {
        return getAllPlayers().filter {country == it.country && gender == it.gender && it.national == 1}
    }

    override suspend fun playersFromNationalLegend(country: String, gender: Enums.Gender): List<CategoryModel> {
        return getAllPlayers().filter { country == it.country && gender == it.gender && it.nationalLegend == 1 }
    }

    override suspend fun insertPlayer(categoryModel: CategoryModel) {
        pocketDataSource.insertLink(categoryModel)
    }

    override suspend fun updatePlayer(categoryModel: CategoryModel) {
        pocketDataSource.updateCategory(categoryModel)
    }


}