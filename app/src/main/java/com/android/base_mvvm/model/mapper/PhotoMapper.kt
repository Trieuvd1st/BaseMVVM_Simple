package com.android.base_mvvm.model.mapper

import com.android.base_mvvm.data.database.photo.PhotoEntity
import com.android.base_mvvm.model.Photo

fun PhotoEntity.toPhoto() = Photo(
    id = id,
    title = title
)