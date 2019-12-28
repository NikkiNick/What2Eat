[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [RecipeOverzichtViewModel](./index.md)

# RecipeOverzichtViewModel

`class RecipeOverzichtViewModel : ViewModel`

ViewModel voor business logica rond een overzicht van recepten. Recepten die een gegeven ingredientennaam
bevatten worden opgehaald en weergegeven.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeOverzichtViewModel(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>ViewModel voor business logica rond een overzicht van recepten. Recepten die een gegeven ingredientennaam bevatten worden opgehaald en weergegeven. |

### Properties

| Name | Summary |
|---|---|
| [naam](naam.md) | `val naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Gegeven ingredientennaam |
| [recipeRepo](recipe-repo.md) | `lateinit var recipeRepo: `[`RecipeApiRepository`](../../android.com.what2eat.repositories/-recipe-api-repository/index.md)<br>Injected properties |
| [response](response.md) | `val response: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`>>`<br>Response van de API-call |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob`<br>CoRoutine properties |

### Functions

| Name | Summary |
|---|---|
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen als het ViewModel wordt afgebroken. [viewModelJob](view-model-job.md) wordt afgesloten. |
