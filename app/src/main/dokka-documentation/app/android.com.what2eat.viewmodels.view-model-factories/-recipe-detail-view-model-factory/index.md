[app](../../index.md) / [android.com.what2eat.viewmodels.viewModelFactories](../index.md) / [RecipeDetailViewModelFactory](./index.md)

# RecipeDetailViewModelFactory

`class RecipeDetailViewModelFactory : Factory`

Factory voor het aanmaken van een [RecipeDetailViewModel](../../android.com.what2eat.viewmodels/-recipe-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met
een gegeven recept.

### Parameters

`recipe` - Gegeven recept

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeDetailViewModelFactory(recipe: `[`RecipeData`](../../android.com.what2eat.network/-recipe-data/index.md)`)`<br>Factory voor het aanmaken van een [RecipeDetailViewModel](../../android.com.what2eat.viewmodels/-recipe-detail-view-model/index.md). Dit ViewModel wordt aangemaakt met een gegeven recept. |

### Properties

| Name | Summary |
|---|---|
| [recipe](recipe.md) | `val recipe: `[`RecipeData`](../../android.com.what2eat.network/-recipe-data/index.md)<br>Gegeven recept |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel?> create(modelClass: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<`[`T`](create.md#T)`>): `[`T`](create.md#T)<br>Creëert het [RecipeDetailViewModel](../../android.com.what2eat.viewmodels/-recipe-detail-view-model/index.md) met gegeven recept |
