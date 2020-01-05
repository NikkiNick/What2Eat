package android.com.what2eat.activities

import android.com.what2eat.R
import android.com.what2eat.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

/**
 *  Globale Activity voor de What2Eat applicatie
 *  @property drawerLayout DrawerLayout voor MaterialDesign NavDrawer
 *  @property appBarConfiguration AppBarConfiguration voor het toevoegen van de NavDrawer aan de navigatie
 *  @property binding Binding object dat gebruikt wordt doorheen [MainActivity]
 */
class MainActivity : AppCompatActivity() {
    /*
    Properties
     */
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    /**
     * Deze functie wordt opgeroepen wanneer [MainActivity] aangemaakt wordt en in CREATED lifecycle state gaat.
     * Hier wordt de layoutBinding geinitialiseerd en de DrawerLayout toegevoegd aan de [MainActivity]-layout.
     * @param savedInstanceState Bundel die gebruikt wordt om data terug in [MainActivity] te initialiseren.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = this.binding.drawerLayout

    }

    /**
     * Deze functie wordt gebruikt door de verschillende fragments voor het instellen van een custom ActionBar titel,
     * alsook het toevoegen van de NavController en  DrawerLayout.
     * @param title Titel die ingesteld wordt in ActionBar van [MainActivity]
     */
    fun setCustomActionBar(title: String){
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, this.drawerLayout)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        when(title){
            "welcome" -> supportActionBar?.setCustomView(R.layout.actionbar_welcome)
            "maaltijdoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meals)
            "maaltijdonderdelenoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meal_parts)
            "about" -> supportActionBar?.setCustomView(R.layout.actionbar_about)
            "add_new_meal" -> supportActionBar?.setCustomView(R.layout.actionbar_add_new_meal)
            "maaltijddetail" -> supportActionBar?.setCustomView(R.layout.actionbar_my_meal)
            "maaltijdonderdeeldetail" -> supportActionBar?.setCustomView(R.layout.actionbar_my_mealpart)
            "edit_meal" -> supportActionBar?.setCustomView(R.layout.actionbar_edit_meal)
            "recipedetail" -> supportActionBar?.setCustomView(R.layout.actionbar_recipe)
            "recipeoverzicht" -> supportActionBar?.setCustomView(R.layout.actionbar_recipes)
        }
        NavigationUI.setupActionBarWithNavController(this, navController, this.drawerLayout)
        NavigationUI.setupWithNavController(this.binding.navView, navController)
    }

    /**
     * Deze functie wordt opgeroepen wanneer de gebruiker de NavigateUp button gebruikt.
     * @retun [Boolean]
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
