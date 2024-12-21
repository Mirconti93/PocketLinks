package com.mirconti.pocketlinks.domain.repository

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mirconti.pocketlinks.domain.models.AssociationModel

interface AssociationRepository {
    suspend fun getAllAssociations(): List<AssociationModel>
    suspend fun addAssociation(categoryModel: AssociationModel)
    suspend fun updateAssociation(categoryModel: AssociationModel)
    suspend fun deleteAssociation(categoryModel: AssociationModel)
}