[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [RecipeListener](./index.md)

# RecipeListener

`class RecipeListener`

Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
Wanneer de gebruiker op een [Recipe](../../android.com.what2eat.network/-recipe/index.md) clickt in de RecyclerView wordt de [RecipeData](../../android.com.what2eat.network/-recipe-data/index.md) teruggegeven.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeListener(clickListener: (recipe: `[`RecipeData`](../../android.com.what2eat.network/-recipe-data/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)`<br>Constructor voor het aanmaken van een [RecipeListener](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: (recipe: `[`RecipeData`](../../android.com.what2eat.network/-recipe-data/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onClick](on-click.md) | `fun onClick(recipe: `[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
