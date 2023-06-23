package org.android.go.sopt.data.remote.service
import org.android.go.sopt.data.remote.response.BaseResponse
import org.android.go.sopt.data.remote.response.ResponseReqresDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("api/users?page=2")
    fun getMembers(
        @Query("page") page: Int,
    ): Call<BaseResponse<ResponseReqresDto>>
}
