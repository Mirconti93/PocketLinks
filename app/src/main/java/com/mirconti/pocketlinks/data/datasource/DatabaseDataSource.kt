package com.mircontapp.sportalbum.data.datasource

import com.mircontapp.sportalbum.data.database.AppDatabase
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.commons.associationModelFromEntity
import com.mirconti.pocketlinks.commons.categoryModelFromEntity
import com.mirconti.pocketlinks.commons.entityFromCategoryModel
import com.mirconti.pocketlinks.commons.entityFromLinkModel
import com.mirconti.pocketlinks.commons.linkModelFromEntity
import com.mirconti.pocketlinks.domain.datasource.PocketDataSource
import com.mirconti.pocketlinks.domain.models.AssociationModel


class DatabaseDataSource : PocketDataSource {
    private val links: MutableList<LinkModel> = ArrayList()
    private val categories: MutableList<CategoryModel> = ArrayList()
    private val associations: MutableList<AssociationModel> = ArrayList()
    private val database: AppDatabase? = AppDatabase.getInstance(PocketApplication.instance.applicationContext)

    private fun fetchAssociations(): List<AssociationModel>? {
        if (associations.isEmpty()) {
            database?.associationDao()?.getAll()?.forEach {
                    association ->associations.add(association.associationModelFromEntity())
            }
        }

        return associations
    }

    override suspend fun fetchLinks(): List<LinkModel> {
        if (links.isEmpty()) {
            fetchAssociations()
            fetchCategories()
            database?.linkDao()?.getAll()?.forEach { link ->
                var associatedCategories: MutableList<CategoryModel> = ArrayList()
                associations.filter { it.link === link.name}.forEach { association->
                    categories.find {it.name === association.category}?.let {
                        associatedCategories.add(it)
                    }
                }
                links.add(link.linkModelFromEntity(associatedCategories))
            }
        }

        return links
    }

    override suspend fun fetchCategories(): List<CategoryModel> {
        if (categories.isEmpty()) {
            database?.categoryDao()?.getAll()?.map {
                it.categoryModelFromEntity()
            }?.let{
                categories.addAll(it)
            }
        }

        return categories
    }

    override suspend fun insertLink(linkModel: LinkModel) {
        database?.linkDao()?.insert(linkModel.entityFromLinkModel())
    }

    override suspend fun updateLink(linkModel: LinkModel) {
        database?.linkDao()?.update(linkModel.entityFromLinkModel())
    }

    override suspend fun deleteLink(linkModel: LinkModel) {
        database?.linkDao()?.delete(linkModel.entityFromLinkModel())
    }

    override suspend fun insertCategory(categoryModel: CategoryModel) {
       database?.categoryDao()?.insert(categoryModel.entityFromCategoryModel())
    }

    override suspend fun updateCategory(categoryModel: CategoryModel) {
        database?.categoryDao()?.update(categoryModel.entityFromCategoryModel())
    }

    override suspend fun deleteCategory(categoryModel: CategoryModel) {
        database?.categoryDao()?.delete(categoryModel.entityFromCategoryModel())
    }



}