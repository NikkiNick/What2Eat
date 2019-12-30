[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [RecipeApiRepository](./index.md)

# RecipeApiRepository

`class RecipeApiRepository`

Repository voor het het uitvoeren van API-operaties rond recepten

### Parameters

`recipeApi` - API Interface gebruikt voor API-calls

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeApiRepository(recipeApi: `[`RecipeApi`](../../android.com.what2eat.network/-recipe-api/index.md)`)`<br>Repository voor het het uitvoeren van API-operaties rond recepten |

### Properties

| Name | Summary |
|---|---|
| [recipeApi](recipe-api.md) | `val recipeApi: `[`RecipeApi`](../../android.com.what2eat.network/-recipe-api/index.md)<br>API Interface gebruikt voor API-calls |

### Functions

| Name | Summary |
|---|---|
| [searchRecipes](search-recipes.md) | `fun searchRecipes(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Deferred<`[`Response`](../../android.com.what2eat.network/-response/index.md)`>`<br>Functie voor het opzoeken van recepten aan de hand van een gegeven ingredient. |
