package org.android.go.sopt.data.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignInDto(
    @SerialName("id")
    val id: String,
    @SerialName("password")
    val password: String,
)
