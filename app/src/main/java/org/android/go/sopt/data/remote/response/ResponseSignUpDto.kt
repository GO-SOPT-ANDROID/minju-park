package org.android.go.sopt.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignUpDto(
    @SerialName("name")
    val name: String,
    @SerialName("skill")
    val skill: String,
)
