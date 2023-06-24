package org.android.go.sopt.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.ServicePool.signUpService
import org.android.go.sopt.data.model.request.RequestSignUpDto
import org.android.go.sopt.data.model.response.BaseResponse
import org.android.go.sopt.data.model.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewmodel : ViewModel() {

    private val _signUpResult: MutableLiveData<BaseResponse<ResponseSignUpDto>> = MutableLiveData()
    val signUpResult: LiveData<BaseResponse<ResponseSignUpDto>> = _signUpResult

    private val _errorResult: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = _errorResult

    val _id: MutableLiveData<String> = MutableLiveData("")
    val _pw: MutableLiveData<String> = MutableLiveData("")
    val _name: MutableLiveData<String> = MutableLiveData("")
    val _skill: MutableLiveData<String> = MutableLiveData("")
    suspend fun signUp(id: String, password: String, name: String, skill: String) {
        signUpService.login(
            RequestSignUpDto(
                id,
                password,
                name,
                skill,
            ),
        ).enqueue(object : Callback<BaseResponse<ResponseSignUpDto>>{
            override fun onResponse(
                call: Call<BaseResponse<ResponseSignUpDto>>,
                response: Response<BaseResponse<ResponseSignUpDto>>,
            ) {
                if (response.isSuccessful) {
                    _signUpResult.value = response.body()
                } else {
                    _errorResult.value = response.message()
                }
            }

            override fun onFailure(call: Call<BaseResponse<ResponseSignUpDto>>, t: Throwable) {
                _errorResult.value = t.toString()
            }
        })
    }
}
