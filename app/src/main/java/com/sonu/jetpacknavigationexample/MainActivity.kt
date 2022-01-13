package com.sonu.jetpacknavigationexample

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sonu.jetpacknavigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.home_nav) as NavHostFragment
        navController = navHost.navController

        setSupportActionBar(binding.toolbar)

        //for showing the hamburger icon we have to pass drawerLayout
        appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.searchFragment, R.id.homeFragment),
                binding.drawerLayout
            )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.homeBottomNav.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.termsAndFragmentItem) {
            val action = NavGraphDirections.actionGlobalTermsAndConditionsFragment()
            navController.navigate(action)
            return true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        //for handling drawer hamburger click we have to pass appbarConfiguration
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}