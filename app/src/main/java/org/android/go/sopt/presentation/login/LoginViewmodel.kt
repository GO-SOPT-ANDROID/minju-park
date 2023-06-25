package org.android.go.sopt.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.android.go.sopt.data.ServicePool.signInService
import org.android.go.sopt.data.model.request.RequestSignInDto
import org.android.go.sopt.data.model.response.BaseResponse
import org.android.go.sopt.data.model.response.ResponseSignInDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor() : ViewModel() {

    private val _signInResult: MutableLiveData<BaseResponse<ResponseSignInDto>> = MutableLiveData()
    val signInResult: LiveData<BaseResponse<ResponseSignInDto>> = _signInResult

    private val _errorResult: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = _errorResult

    val _id: MutableLiveData<String> = MutableLiveData("")
    val _pw: MutableLiveData<String> = MutableLiveData("")

    fun signIn(id: String, password: String) {
        signInService.signin(
            RequestSignInDto(
                id,
                password,
            ),
        ).enqueue(object : Callback<BaseResponse<ResponseSignInDto>> {
            override fun onResponse(
                call: Call<BaseResponse<ResponseSignInDto>>,
                response: Response<BaseResponse<ResponseSignInDto>>,
            ) {
                if (response.isSuccessful) {
                    _signInResult.value = response.body()
                } else {
                    _errorResult.value = response.message()
                }
            }

            override fun onFailure(call: Call<BaseResponse<ResponseSignInDto>>, t: Throwable) {
                _errorResult.value = t.toString()
            }
        })
    }
}
