package org.android.go.sopt.data.remote.service
import org.android.go.sopt.data.remote.model.ResponseReqresDto
import retrofit2.Call
import retrofit2.http.GET

interface ReqresService {
    @GET("/api/users?page=2")
    fun getMembers(): Call<ResponseReqresDto>
}