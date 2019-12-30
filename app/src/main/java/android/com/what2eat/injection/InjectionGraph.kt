package android.com.what2eat.injection

import android.com.what2eat.fragments.MaaltijdEditFragment
import android.com.what2eat.viewmodels.*
import dagger.Component
import javax.inject.Singleton

/**
 * Deze InjectionGraph wordt gebruikt in de applicatie om aan te geven waar de verschillende
 * injecteerbare singletons beschikbaar gesteld moeten worden.
 */
@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface InjectionGraph {

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdDetailViewModel ViewModel
     */
    fun inject(maaltijdDetailViewModel: MaaltijdDetailViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdOverzichtViewModel ViewModel
     */
    fun inject(maaltijdOverzichtViewModel: MaaltijdOverzichtViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param recipeOverzichtViewModel ViewModel
     */
    fun inject(recipeOverzichtViewModel: RecipeOverzichtViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdOnderdeelOverzichtViewModel ViewModel
     */
    fun inject(maaltijdOnderdeelOverzichtViewModel: MaaltijdOnderdeelOverzichtViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdOnderdeelSelectViewModel ViewModel
     */
    fun inject(maaltijdOnderdeelSelectViewModel: MaaltijdOnderdeelSelectViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdOnderdeelDetailViewModel ViewModel
     */
    fun inject(maaltijdOnderdeelDetailViewModel: MaaltijdOnderdeelDetailViewModel)

    /**
     * Injecteerd dependecies in ViewModel
     * @param maaltijdEditFragment ViewModel
     */
    fun inject(maaltijdEditFragment: MaaltijdEditFragment)

    /**
     * InjectionGraph Builder
     */
    @Component.Builder
    interface Builder {
        /**
         * Voor het builden van InjectionGraph
         */
        fun build(): InjectionGraph

        /**
         * Voor het builden van de databaseModule
         * @param databaseModule DatabaseModule
         */
        fun databaseModule(databaseModule: DatabaseModule): Builder

        /**
         * Voor het builden van de networkModule
         * @param networkModule NetworkModule
         */
        fun networkModule(networkModule: NetworkModule): Builder
    }
}