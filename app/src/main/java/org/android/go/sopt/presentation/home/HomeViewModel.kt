package org.android.go.sopt.presentation.home

import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.local.music
import org.android.go.sopt.R

class HomeViewModel:ViewModel() {

    val mokMusicList = listOf<music>(
        music(R.drawable.introduce_photo, "55", "Codekunst"),
        music(R.drawable.introduce_photo, "ride", "wave to earth"),
        music(R.drawable.introduce_photo, "Big world", "백예린"),
        music(R.drawable.introduce_photo, "No Surprises", "Radiohead"),
        music(R.drawable.introduce_photo, "바다처럼", "Dasutt"),
        music(R.drawable.introduce_photo, "덫", "서동현"),
        music(R.drawable.introduce_photo,"집에 가는 길","하현상"),
        music(R.drawable.introduce_photo,"Journey","woodz"),
        music(R.drawable.introduce_photo,"Sun and Moon","Sam Kim")

    )

}