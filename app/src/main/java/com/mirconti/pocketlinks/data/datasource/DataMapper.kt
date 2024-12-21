package com.mircontapp.sportalbum.data.datasource

import com.mircontapp.sportalbum.data.database.Category
import com.mircontapp.sportalbum.data.database.Link
import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel

class DataMapper {
    companion object {
        fun entityFromLinkModel(link: LinkModel) : Link {
            return Link(
                name = link.name,
                url = link.url,
                type = link.type,
                favourite = link.favourite
            )
        }

        fun linkModelFromEntity(link: Link) : LinkModel {
            return LinkModel(
                name = link.name,
                url = link.url,
                categories = emptyList(),
                type = link.type,
                favourite = link.favourite
            )
        }

        fun categoryModelFromEntity(category: Category) : CategoryModel {
            return CategoryModel(
                name = category.name,
                categoryUp = category.categoryUp
            )
        }

        fun entityFromCategoryModel(category: CategoryModel) : Category {
            return Category(
                name = category.name,
                categoryUp = category.categoryUp
            )
        }

    }

}