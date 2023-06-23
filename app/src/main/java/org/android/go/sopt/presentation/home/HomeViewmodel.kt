package org.android.go.sopt.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.ServicePool.reqresService
import org.android.go.sopt.data.remote.response.ResponseReqresDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewmodel : ViewModel() {
    private val _getUserResult: MutableLiveData<ResponseReqresDto> = MutableLiveData()
    val getUserResult: LiveData<ResponseReqresDto> = _getUserResult

    private val _errorResult: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = _errorResult

    fun getUser() {
        reqresService.getMembers(1).enqueue(object : Callback<ResponseReqresDto> {
            override fun onResponse(
                call: Call<ResponseReqresDto>,
                response: Response<ResponseReqresDto>,
            ) {
                if (response.isSuccessful) {
                    _getUserResult.value = response.body()
                } else {
                    _errorResult.value = response.message()
                }
            }

            override fun onFailure(call: Call<ResponseReqresDto>, t: Throwable) {
                _errorResult.value = t.toString()
            }
        })
    }
}
