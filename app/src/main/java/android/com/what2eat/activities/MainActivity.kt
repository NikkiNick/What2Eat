package android.com.what2eat.activities

import android.Manifest
import android.com.what2eat.R
import android.com.what2eat.databinding.ActivityMainBinding
import android.com.what2eat.viewmodels.ActionbarViewModel
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
    //private lateinit var actionbarViewModel: ActionbarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //actionbarViewModel = ViewModelProviders.of(this).get(ActionbarViewModel::class.java)
        drawerLayout = this.binding.drawerLayout

        /*actionbarViewModel.title.observe(this, Observer{
            it?.let{
                setCustomActionBar()
            }
        })*/
        binding.lifecycleOwner = this

    }


    fun setCustomActionBar(fragment: String){
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, this.drawerLayout)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        //supportActionBar?.setCustomView(R.layout.custom_actionbar)
        when(fragment){
            "welcome" -> supportActionBar?.setCustomView(R.layout.actionbar_welcome)
            "maaltijdoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meals)
            "maaltijdonderdelenoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meal_parts)
            "about" -> supportActionBar?.setCustomView(R.layout.actionbar_about)
            "add_new_meal" -> supportActionBar?.setCustomView(R.layout.actionbar_add_new_meal)
            "maaltijddetail" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meal)
            "edit_meal" -> supportActionBar?.setCustomView(R.layout.actionbar_edit_meal)
        }
        NavigationUI.setupActionBarWithNavController(this, navController, this.drawerLayout)
        NavigationUI.setupWithNavController(this.binding.navView, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
