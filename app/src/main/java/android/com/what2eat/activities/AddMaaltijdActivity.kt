package android.com.what2eat.activities

import android.com.what2eat.R
import android.com.what2eat.databinding.ActivityAddMaaltijdBinding
import android.com.what2eat.viewmodels.MaaltijdViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class AddMaaltijdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMaaltijdBinding
    private lateinit var viewModel: MaaltijdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        this.binding = DataBindingUtil.setContentView<ActivityAddMaaltijdBinding>(this, R.layout.activity_add_maaltijd)
        this.viewModel = ViewModelProviders.of(this).get(MaaltijdViewModel::class.java)
        viewModel.maaltijd.value?.naam = "test"

        val navController = findNavController(R.id.myNavHostFragment_AddMeal)

        NavigationUI.setupActionBarWithNavController(this, navController)
        getSupportActionBar()!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        getSupportActionBar()!!.setCustomView(R.layout.actionbar_add_new_meal)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

}