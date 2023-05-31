package org.android.go.sopt.data.remote.Interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val headerRequest = originalRequest.newBuilder()
            .header("Authorization <- 키 값은 이걸로 주로 사용합니다.", "")
            .build()

        return chain.proceed(headerRequest)
    }
}
