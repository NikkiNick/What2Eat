[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [RecipeDiffCallback](./index.md)

# RecipeDiffCallback

`class RecipeDiffCallback : ItemCallback<`[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`>`

Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Recipe](../../android.com.what2eat.network/-recipe/index.md)
beter te kunnen uitmaken.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeDiffCallback()`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Recipe](../../android.com.what2eat.network/-recipe/index.md) beter te kunnen uitmaken. |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`, newItem: `[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of de inhoud van 2 objecten ([Recipe](../../android.com.what2eat.network/-recipe/index.md)) dezelfde te zijn |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`, newItem: `[`Recipe`](../../android.com.what2eat.network/-recipe/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of 2 objecten ([Recipe](../../android.com.what2eat.network/-recipe/index.md)) dezelfde te zijn door beide id's te vergelijken |
