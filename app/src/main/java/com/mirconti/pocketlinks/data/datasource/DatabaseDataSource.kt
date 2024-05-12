package com.mircontapp.sportalbum.data.datasource

import com.mircontapp.sportalbum.data.database.AppDatabase
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.PocketApplication


class DatabaseDataSource : PocketDataSource {
    private val players: MutableList<CategoryModel> = ArrayList()
    private val teams: MutableList<LinkModel> = ArrayList()
    val database: AppDatabase?

    init {
       database = AppDatabase.getInstance(PocketApplication.instance.applicationContext)
    }

    override suspend fun fetchLinks(): List<CategoryModel>? {
        if (players.isEmpty()) {
            database?.linkDao()?.getAll()?.forEach { player ->
                players.add(DataMapper.playerModelFromEntity(player))
            }
        }
        return players
    }

    override suspend fun fetchCategories(): List<LinkModel>? {
        if (teams.isEmpty()) {
            database?.categoryDao()?.getAll()?.forEach {
                    team ->teams.add(DataMapper.teamModelFromEntity(team))
            }
        }

        return teams
    }

    override suspend fun insertLink(categoryModel: CategoryModel) {
        database?.linkDao()?.insert(DataMapper.entityFromPlayerModel(categoryModel))
    }

    override suspend fun updateCategory(categoryModel: CategoryModel) {
        database?.linkDao()?.update(DataMapper.entityFromPlayerModel(categoryModel))
    }

    override suspend fun updateTeam(linkModel: LinkModel) {
        database?.categoryDao()?.update(DataMapper.entityFromTeamModel(linkModel))
    }

    override suspend fun insertTeam(linkModel: LinkModel) {
        database?.categoryDao()?.insert(DataMapper.entityFromTeamModel(linkModel))
    }

    fun insertAllTeams(teams: List<LinkModel>?) {
        val teamsEntities = ArrayList<Team>()
        teams?.forEach { teamsEntities.add(DataMapper.entityFromTeamModel(it)) }
        database?.categoryDao()?.insertAll(teamsEntities)
    }

    fun insertAllPlayers(players: List<CategoryModel>?) {
        val playerEntities = ArrayList<Player>()
        players?.forEach { playerEntities.add(DataMapper.entityFromPlayerModel(it)) }
        database?.linkDao()?.insertAll(playerEntities)
    }


}