package org.android.go.sopt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.android.go.sopt.Fragment.GalleryFragment
import org.android.go.sopt.Fragment.HomeFragment
import org.android.go.sopt.Fragment.SearchFragement
import org.android.go.sopt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFragment(HomeFragment())

        binding.bottomNavi.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_home -> {
                    changeFragment(HomeFragment())
                }
                R.id.menu_gallery->{
                    changeFragment(GalleryFragment())
                }
                R.id.menu_search -> {
                    changeFragment(SearchFragement())
                }
            }
            true
        }

    }


    private fun startFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fcv, fragment)
            .commit()
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv,fragment)
            .commit()
    }
}





