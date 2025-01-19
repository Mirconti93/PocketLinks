package com.mirconti.pocketlinks.presentation.navigation

import com.mircontapp.sportalbum.domain.models.LinkModel
import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Home

    @Serializable
    data class Edit(val link: String?)

}