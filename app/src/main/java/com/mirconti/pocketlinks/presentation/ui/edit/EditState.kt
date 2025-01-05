package com.mirconti.pocketlinks.presentation.ui.edit

import com.mircontapp.sportalbum.domain.models.LinkModel

data class EditState(val isLoading: Boolean = false, val linkModel: LinkModel? = null)