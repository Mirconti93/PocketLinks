package com.mirconti.pocketlinks.data.datasource

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.mircontapp.sportalbum.data.database.AppDatabase
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.models.toCategoryModel
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.commons.associationModelFromEntity
import com.mirconti.pocketlinks.commons.categoryModelFromEntity
import com.mirconti.pocketlinks.commons.entityFromCategoryModel
import com.mirconti.pocketlinks.commons.entityFromLinkModel
import com.mirconti.pocketlinks.commons.linkModelFromEntity
import com.mirconti.pocketlinks.data.remote.LinkResponse
import com.mirconti.pocketlinks.data.remote.toLinkModel
import com.mirconti.pocketlinks.domain.datasource.PocketDataSource
import com.mirconti.pocketlinks.domain.models.AssociationModel


class FirebaseDataSource : PocketDataSource {
    private val links: MutableList<LinkModel> = mutableListOf()
    private val categories: MutableList<CategoryModel> = mutableListOf()
    private val associations: MutableList<AssociationModel> = mutableListOf()

    private val db by lazy { FirebaseFirestore.getInstance() }

    private val LINKS_TABLE = "links"

    override suspend fun fetchLinks(): List<LinkModel> {
        if (links.isEmpty()) {
            db.collection(LINKS_TABLE)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("Firebase", "${document.id} => ${document.data}")
                        val link = document.toObject(LinkResponse::class.java)
                        links.add(link.toLinkModel())
                    }
                }
        }

        return links
    }

    override suspend fun fetchCategories(): List<CategoryModel> {
        if (categories.isEmpty()) {
            categories.addAll(fetchLinks().flatMap{ categories }.distinct().toList())
        }

        return categories
    }

    override suspend fun insertLink(linkModel: LinkModel) {
        db.collection(LINKS_TABLE)
            .add(linkModel)
            .addOnSuccessListener {
                Log.d("Firebase", "Link aggiunto")
            }
            .addOnFailureListener {
                Log.e("Firebase", "Errore", it)
            }
    }

    override suspend fun updateLink(linkModel: LinkModel) {
        //todo
    }

    override suspend fun deleteLink(linkModel: LinkModel) {
        //todo
    }

    override suspend fun insertCategory(categoryModel: CategoryModel) {
       //todo
    }

    override suspend fun updateCategory(categoryModel: CategoryModel) {
        //todo
    }

    override suspend fun deleteCategory(categoryModel: CategoryModel) {
        //todo
    }



}