package com.example.familysafety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.familysafety.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inflateFragment(HomeFragment.newInstance())

        binding.bottomBar.setOnItemSelectedListener {

            if(it.itemId == R.id.nav_guard){
                inflateFragment(GuardFragment.newInstance())
            }else if(it.itemId == R.id.nav_home){
                inflateFragment(HomeFragment.newInstance())
            }else if(it.itemId == R.id.nav_profile){
                inflateFragment(ProfileFragment.newInstance())
            }else{
                inflateFragment(DashboardFragment.newInstance())
            }

            true
        }

    }

    private fun inflateFragment(newInstance:Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}