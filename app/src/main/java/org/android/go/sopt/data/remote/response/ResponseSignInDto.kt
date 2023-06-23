package org.android.go.sopt.data.remote.response

import kotlinx.serialization.SerialName

data class ResponseSignInDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("skill")
    val skill: String?,
)
