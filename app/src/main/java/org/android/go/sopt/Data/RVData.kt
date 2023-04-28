package org.android.go.sopt.Data

import androidx.annotation.DrawableRes

class RVData (
    @DrawableRes
    //만약 이후 이 image에 리소스 값이 아닌 단순 Int 값이 들어갈 경우 컴파일 타임에 에러를 발생
    val image:Int,
    val song:String,
    val singer:String
    )