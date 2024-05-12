package com.mircontapp.sportalbum.domain.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.domain.models.CategoryModel

interface PlayersRepository {

    suspend fun getAllPlayers(): List<CategoryModel>
    suspend fun playersFromTeam(teamName: String) : List<CategoryModel>
    suspend fun playersFromTeamLegend(teamName: String): List<CategoryModel>
    suspend fun playersFromNational(country: String, gender: Enums.Gender): List<CategoryModel>
    suspend fun playersFromNationalLegend(country: String, gender: Enums.Gender): List<CategoryModel>
    suspend fun insertPlayer(categoryModel: CategoryModel)
    suspend fun updatePlayer(categoryModel: CategoryModel)
}