package android.com.what2eat.activities

import android.com.what2eat.R
import android.com.what2eat.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

/**
 *  MainActivity
 */
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = this.binding.drawerLayout

        setCustomActionBar("welcome")

    }


    fun setCustomActionBar(fragment: String){
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, this.drawerLayout)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        when(fragment){
            "welcome" -> supportActionBar?.setCustomView(R.layout.actionbar_welcome)
            "maaltijdoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meals)
            "about" -> supportActionBar?.setCustomView(R.layout.actionbar_about)
        }
        NavigationUI.setupActionBarWithNavController(this, navController, this.drawerLayout)
        NavigationUI.setupWithNavController(this.binding.navView, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
