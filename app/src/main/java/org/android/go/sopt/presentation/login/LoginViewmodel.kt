package org.android.go.sopt.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.android.go.sopt.data.ServicePool.signInService
import org.android.go.sopt.data.model.request.RequestSignInDto
import org.android.go.sopt.data.model.response.BaseResponse
import org.android.go.sopt.data.model.response.ResponseSignInDto
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor() : ViewModel() {

    private val _signInResult: MutableLiveData<BaseResponse<ResponseSignInDto>> = MutableLiveData()
    val signInResult: LiveData<BaseResponse<ResponseSignInDto>> = _signInResult

    private val _errorResult: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = _errorResult

    val _id: MutableLiveData<String> = MutableLiveData("")
    val _pw: MutableLiveData<String> = MutableLiveData("")

    fun login() {
        viewModelScope.launch {
            kotlin.runCatching {
                signInService.signin(
                    RequestSignInDto(
                        _id.toString(),
                        _pw.toString(),
                    ),
                )
            }.fold(
                {
                    Timber.d("로그인 조회 성공")
                    _signInResult.value = it
                },
                {
                    Timber.e(it.message)
                },
            )
        }
    }
}
