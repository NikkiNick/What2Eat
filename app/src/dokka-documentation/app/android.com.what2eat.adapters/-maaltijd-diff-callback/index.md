[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdDiffCallback](./index.md)

# MaaltijdDiffCallback

`class MaaltijdDiffCallback : ItemCallback<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>`

Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Maaltijden](#)
beter te kunnen uitmaken.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDiffCallback()`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Maaltijden](#) beter te kunnen uitmaken. |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`, newItem: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of de inhoud van 2 objecten ([Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md)) dezelfde te zijn |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`, newItem: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of 2 objecten ([Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md)) dezelfde te zijn door beide id's te vergelijken |
