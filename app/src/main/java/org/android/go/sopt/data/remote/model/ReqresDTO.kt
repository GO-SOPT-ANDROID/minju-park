package org.android.go.sopt.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReqresDto(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val per_page: String,
    @SerialName("total")
    val total: String,
    @SerialName("total_pages")
    val total_pages: String,
    @SerialName("data")
    val data: ReqresData,
) {
    @Serializable
    data class ReqresData(
        @SerialName("id")
        val id: Int,
        @SerialName("email")
        val email: String,
        @SerialName("first_name")
        val first_name: String,
        @SerialName("last_name")
        val last_name: String,
        @SerialName("avatar")
        val avatar: String,
    )
}