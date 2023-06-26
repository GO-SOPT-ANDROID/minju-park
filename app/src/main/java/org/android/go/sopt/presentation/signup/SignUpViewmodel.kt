package org.android.go.sopt.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.android.go.sopt.data.ServicePool.signUpService
import org.android.go.sopt.data.model.request.RequestSignUpDto
import org.android.go.sopt.data.model.response.BaseResponse
import org.android.go.sopt.data.model.response.ResponseSignUpDto
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewmodel @Inject constructor() : ViewModel() {

    private val _signUpResult: MutableLiveData<BaseResponse<ResponseSignUpDto>> = MutableLiveData()
    val signUpResult: LiveData<BaseResponse<ResponseSignUpDto>> = _signUpResult

    private val _errorResult: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = _errorResult

    val _id: MutableLiveData<String> = MutableLiveData("")
    val _pw: MutableLiveData<String> = MutableLiveData("")
    val _name: MutableLiveData<String> = MutableLiveData("")
    val _skill: MutableLiveData<String> = MutableLiveData("")
    fun signUp() {
        viewModelScope.launch {
            kotlin.runCatching {
                signUpService.login(
                    RequestSignUpDto(
                        _id.toString(),
                        _name.toString(),
                        _pw.toString(),
                        _skill.toString(),
                    ),
                )
            }.fold(
                {
                    Timber.d("로그인 조회 성공")
                    _signUpResult.value = it
                },
                {
                    Timber.e(it.message)
                },
            )
        }
    }
}
