[app](../../index.md) / [android.com.what2eat.viewmodels.viewModelFactories](../index.md) / [RecipeOverzichtViewModelFactory](./index.md)

# RecipeOverzichtViewModelFactory

`class RecipeOverzichtViewModelFactory : Factory`

Factory voor het aanmaken van een [RecipeOverzichtViewModel](../../android.com.what2eat.viewmodels/-recipe-overzicht-view-model/index.md). Dit ViewModel wordt aangemaakt met
een gegeven naam van een ingredient.

### Parameters

`naam` - Naam van het ingredient

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeOverzichtViewModelFactory(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Factory voor het aanmaken van een [RecipeOverzichtViewModel](../../android.com.what2eat.viewmodels/-recipe-overzicht-view-model/index.md). Dit ViewModel wordt aangemaakt met een gegeven naam van een ingredient. |

### Properties

| Name | Summary |
|---|---|
| [naam](naam.md) | `val naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Naam van het ingredient |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T)<br>Creëert het [RecipeOverzichtViewModel](../../android.com.what2eat.viewmodels/-recipe-overzicht-view-model/index.md) met gegeven ingredientnaam |
