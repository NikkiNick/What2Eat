package android.com.what2eat.viewmodels

import android.com.what2eat.network.RecipeData
import androidx.lifecycle.ViewModel

/**
 * ViewModel voor business logica rond een overzicht van maaltijdOnderdelen.
 * @property recipe [RecipeData] waarrond het ViewModel opgebouwd is
 */
class RecipeDetailViewModel(val recipe: RecipeData): ViewModel() {
}