package com.joysoftgo.base_mvvm.domain.mapper

import com.joysoftgo.base_mvvm.data.database.entities.PhotoEntity
import com.joysoftgo.base_mvvm.domain.model.Photo

fun PhotoEntity.toPhoto() = Photo(
    id = id,
    title = title
)