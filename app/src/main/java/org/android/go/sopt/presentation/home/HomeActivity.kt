package org.android.go.sopt.presentation.home
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.android.go.sopt.presentation.gallery.GalleryFragment
import org.android.go.sopt.presentation.search.SearchFragment
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment(HomeFragment())

        binding.bnvMain.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_home -> {
                    changeFragment(HomeFragment())
                }
                R.id.menu_gallery ->{
                    changeFragment(GalleryFragment())
                }
                else->{
                    changeFragment(SearchFragment())
                }
            }
            true
        }

    }


    private fun startFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction() //프래그먼트 트랜잭션을 시작하는 메서드
            .add(R.id.fcv_main, fragment) //해당 ID를 가진 Container View에 다음 파라미터에 존재하 Fragment를 쌓는다.
            .commit() //모든 트랙잭션을 마침, 트랜잭션 시작
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_main,fragment)
            .commit()
    }
}




