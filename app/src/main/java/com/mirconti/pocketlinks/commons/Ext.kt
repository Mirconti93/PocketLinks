package com.mirconti.pocketlinks.commons

import com.mircontapp.sportalbum.data.database.Association
import com.mircontapp.sportalbum.data.database.Category
import com.mircontapp.sportalbum.data.database.Link
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.domain.models.AssociationModel

fun LinkModel.entityFromLinkModel() : Link {
    return Link(
        name = this.name,
        url = this.url,
        type = this.type,
        favourite = this.favourite
    )
}

fun Link.linkModelFromEntity(categories: List<CategoryModel>) : LinkModel {
    return LinkModel(
        name = this.name,
        url = this.url,
        categories =categories,
        type = this.type,
        favourite = this.favourite
    )
}

fun Category.categoryModelFromEntity() : CategoryModel {
    return CategoryModel(
        name = this.name,
        categoryUp = this.categoryUp
    )
}

fun CategoryModel.entityFromCategoryModel() : Category {
    return Category(
        name = this.name,
        categoryUp = this.categoryUp
    )
}

fun Association.associationModelFromEntity() : AssociationModel {
    return AssociationModel(
        link = this.link,
        category = this.category
    )
}

fun AssociationModel.entityFromAssociationModel() : Association {
    return Association(
        link = this.link,
        category = this.category
    )
}
