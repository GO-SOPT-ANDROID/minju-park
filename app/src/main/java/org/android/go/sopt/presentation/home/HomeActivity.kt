package org.android.go.sopt.presentation.home
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.android.go.sopt.presentation.search.SearchFragment
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityHomeBinding
import org.android.go.sopt.presentation.search.GalleryFragment


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
            .beginTransaction()
            .add(R.id.fcv_main, fragment)
            .commit()
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_main,fragment)
            .commit()
    }
}





