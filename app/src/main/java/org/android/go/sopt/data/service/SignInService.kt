package org.android.go.sopt.data.service

import org.android.go.sopt.data.model.request.RequestSignInDto
import org.android.go.sopt.data.model.response.BaseResponse
import org.android.go.sopt.data.model.response.ResponseSignInDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("sign-in")
    fun signin(
        @Body request: RequestSignInDto,
    ): Call<BaseResponse<ResponseSignInDto>>
}
