package com.mircontapp.sportalbum.data.datasource

import com.mircontapp.sportalbum.data.database.AppDatabase
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.domain.datasource.PocketDataSource


class DatabaseDataSource : PocketDataSource {
    private val links: MutableList<LinkModel> = ArrayList()
    private val teams: MutableList<CategoryModel> = ArrayList()
    val database: AppDatabase?

    init {
       database = AppDatabase.getInstance(PocketApplication.instance.applicationContext)
    }

    override suspend fun fetchLinks(): List<LinkModel>? {
        if (links.isEmpty()) {
            database?.linkDao()?.getAll()?.forEach { link ->
                links.add(DataMapper.linkModelFromEntity(link))
            }
        }
        return links
    }

    override suspend fun fetchCategories(): List<CategoryModel>? {
        if (teams.isEmpty()) {
            database?.categoryDao()?.getAll()?.forEach {
                    team ->teams.add(DataMapper.categoryModelFromEntity(team))
            }
        }

        return teams
    }

    override suspend fun insertLink(linkModel: LinkModel) {
        database?.linkDao()?.insert(DataMapper.entityFromLinkModel(linkModel))
    }

    override suspend fun updateLink(linkModel: LinkModel) {
        database?.linkDao()?.update(DataMapper.entityFromLinkModel(linkModel))
    }

    override suspend fun deleteLink(linkModel: LinkModel) {
        database?.linkDao()?.delete(DataMapper.entityFromLinkModel(linkModel))
    }

    override suspend fun insertCategory(categoryModel: CategoryModel) {
       database?.categoryDao()?.insert(DataMapper.entityFromCategoryModel(categoryModel))
    }

    override suspend fun updateCategory(categoryModel: CategoryModel) {
        database?.categoryDao()?.update(DataMapper.entityFromCategoryModel(categoryModel))
    }

    override suspend fun deleteCategory(categoryModel: CategoryModel) {
        database?.categoryDao()?.delete(DataMapper.entityFromCategoryModel(categoryModel))
    }



}