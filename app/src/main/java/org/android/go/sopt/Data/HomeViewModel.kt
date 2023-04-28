package org.android.go.sopt.Data

import androidx.lifecycle.ViewModel
import org.android.go.sopt.R

class HomeViewModel:ViewModel() {

    val mokMusicList = listOf<RVData>(
        RVData(R.drawable.introduce_photo, "55", "Codekunst"),
        RVData(R.drawable.introduce_photo, "ride", "wave to earth"),
        RVData(R.drawable.introduce_photo, "Big world", "백예린"),
        RVData(R.drawable.introduce_photo, "No Surprises", "Radiohead"),
        RVData(R.drawable.introduce_photo, "바다처럼", "Dasutt"),
        RVData(R.drawable.introduce_photo, "덫", "서동현")
    )

}