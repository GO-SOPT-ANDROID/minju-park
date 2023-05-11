package org.android.go.sopt.data.remote.service

import org.android.go.sopt.data.remote.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignInService {
    @GET("/api/users?page=2")
    fun ReqresData(
    ): Call<ResponseReqresDto>
}