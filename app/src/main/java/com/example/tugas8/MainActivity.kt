package com.example.tugas8

import android.R
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas8.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        @StringRes
        private val tabName = intArrayOf(
            com.example.tugas8.R.string.register, // Use your app's R file
            com.example.tugas8.R.string.login
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            setSupportActionBar(toolbar);
            //implementasi settingan per viewpager
            viewPager.adapter = SectionPagerAdapter(toolbar)
            //hubungin antara tab menjadi viewpager. jadi apa yang dipilih tab nya sesuai dengan yang ditampilkan di view pager
            TabLayoutMediator(tabLayout,viewPager){ tab, position ->
                //berikut merupakan nama tabnya
                tab.text = resources.getString(tabName[position])
            }.attach()

        }
    }
}