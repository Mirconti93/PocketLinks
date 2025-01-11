package com.mirconti.pocketlinks.presentation.ui.edit

import com.mircontapp.sportalbum.domain.models.CategoryModel
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.presentation.ui.home.HomeAction

sealed class EditAction {
    object Load: EditAction()
    data class AddLink(val linkModel: LinkModel, val categories: List<CategoryModel>?): EditAction()
}