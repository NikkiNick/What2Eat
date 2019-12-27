[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [RecipeApiViewModel](./index.md)

# RecipeApiViewModel

`class RecipeApiViewModel : ViewModel`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeApiViewModel(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [naam](naam.md) | `val naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [recipeRepo](recipe-repo.md) | `lateinit var recipeRepo: `[`RecipeApiRepository`](../../android.com.what2eat.repositories/-recipe-api-repository/index.md) |
| [response](response.md) | `val response: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`>>` |
| [viewModelJob](view-model-job.md) | `var viewModelJob: CompletableJob` |

### Functions

| Name | Summary |
|---|---|
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
