package com.mircontapp.sportalbum.domain.models

import com.mirco.sportalbum.utils.Enums

data class LineUpModel(
    val module: Enums.LineUpModule,
    val starting: List<CategoryModel>,
    val availables: List<CategoryModel>,
    val isLegend: Boolean
)