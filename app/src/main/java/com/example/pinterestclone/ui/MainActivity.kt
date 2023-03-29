package com.example.pinterestclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pinterestclone.R
import com.example.pinterestclone.ui.fragment.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtomNavigation()
    }

    private fun setupButtomNavigation() {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.pinterestNavGraphFragment) as  NavHostFragment
        findViewById<BottomNavigationView>(R.id.pinterestNavigatorView).setupWithNavController(
            navHostFragment.navController
        )
    }
}