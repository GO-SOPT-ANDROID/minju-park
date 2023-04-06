package org.android.go.sopt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityIntroduceBinding


class IntroduceActivity :AppCompatActivity(){

    lateinit var binding: ActivityIntroduceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityIntroduceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이름,특기 값 받아오기
        val name=intent.getStringExtra("name")
        val specialty=intent.getStringExtra("specialty")
        binding.tvIntroduceName.text= "이름 : $name"
        binding.tvIntroduceSpecialty.text= "특기 : $specialty"

    }
}
//git add.
//git commit -m "1차 세미나 도전 과제"
//git push origin week1
//