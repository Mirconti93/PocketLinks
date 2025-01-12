package com.mirconti.pocketlinks.domain.usecases

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.domain.repository.LinksRepository
import javax.inject.Inject

class InsertLinkUC @Inject constructor(val linksRepository: LinksRepository) {
    suspend operator fun invoke(linkModel: LinkModel, categories: List<CategoryModel>?) {
        categories?.let {
            linkModel.categories = it

        }
        linksRepository.addLink(linkModel)
    }
}