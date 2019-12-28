[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdOnderdeelDiffCallback](./index.md)

# MaaltijdOnderdeelDiffCallback

`class MaaltijdOnderdeelDiffCallback : ItemCallback<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>`

Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 maaltijdOnderdelen
beter te kunnen uitmaken.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelDiffCallback()`<br>Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 maaltijdOnderdelen beter te kunnen uitmaken. |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, newItem: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of de inhoud van 2 maaltijdOnderdelen dezelfde te zijn |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, newItem: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie bekijkt of 2 maaltijdOnderdelen dezelfde te zijn door beide id's te vergelijken |
