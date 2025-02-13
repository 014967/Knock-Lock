package com.knocklock.presentation.lockscreen.model

import com.knocklock.domain.model.Group as GroupModel
/**
 * @Created by 김현국 2023/03/07
 */
data class Group(
    val key: String
)

fun Group.toModel() = GroupModel(
    key = this.key
)

fun GroupModel.toModel() = Group(
    key = this.key
)
