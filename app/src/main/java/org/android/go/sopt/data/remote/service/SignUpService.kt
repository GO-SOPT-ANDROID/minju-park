package org.android.go.sopt.data.remote.service

import org.android.go.sopt.data.remote.model.RequestSignUpDto
import org.android.go.sopt.data.remote.model.ResponseSignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("sign-up")
    fun login(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>
}
