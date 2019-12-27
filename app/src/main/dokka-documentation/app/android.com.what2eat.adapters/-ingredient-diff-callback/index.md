[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [IngredientDiffCallback](./index.md)

# IngredientDiffCallback

`class IngredientDiffCallback : ItemCallback<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de ingredienten
beter te kunnen uitmaken.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IngredientDiffCallback()`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de ingredienten beter te kunnen uitmaken. |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newItem: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of de inhoud van 2 ingredienten dezelfde te zijn |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newItem: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of 2 ingredienten dezelfde te zijn |
