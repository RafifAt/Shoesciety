package com.example.recyclerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.myfragment.FirstFragment
import com.example.myfragment.SecondFragment
import com.google.android.material.tabs.TabLayout

class RegisterForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)


        val viewPager = findViewById<ViewPager>(R.id.ViewPager)
        val tabLayout = findViewById<TabLayout>(R.id.TabLayout)

        viewPager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}

