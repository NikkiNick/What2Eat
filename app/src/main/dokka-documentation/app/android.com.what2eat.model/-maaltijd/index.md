[app](../../index.md) / [android.com.what2eat.model](../index.md) / [Maaltijd](./index.md)

# Maaltijd

`data class Maaltijd`

Model gebruikt voor een maaltijd

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Maaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0L, dateAdded: `[`Date`](https://developer.android.com/reference/java/util/Date.html)` = Date(), naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, dateLast: `[`Date`](https://developer.android.com/reference/java/util/Date.html)`? = null, photo_uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null)`<br>Model gebruikt voor een maaltijd |

### Properties

| Name | Summary |
|---|---|
| [dateAdded](date-added.md) | `var dateAdded: `[`Date`](https://developer.android.com/reference/java/util/Date.html)<br>Datum wanneer de maaltijd toegevoegd is |
| [dateLast](date-last.md) | `var dateLast: `[`Date`](https://developer.android.com/reference/java/util/Date.html)`?`<br>Datum wanneer de maaltijd laatst gegegeten is |
| [maaltijdId](maaltijd-id.md) | `var maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Id van de maaltijd |
| [maaltijdOnderdelen](maaltijd-onderdelen.md) | `var maaltijdOnderdelen: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`MaaltijdOnderdeel`](../-maaltijd-onderdeel/index.md)`>`<br>MaaltijdOnderdelen ([MaaltijdOnderdeel](../-maaltijd-onderdeel/index.md)) die bij de maaltijd horen |
| [naam](naam.md) | `var naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Naam van de maaltijd |
| [photo_uri](photo_uri.md) | `var photo_uri: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>URI waar de afbeelding van de maaltijd is opgeslaan |
| [rating](rating.md) | `var rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Rating van de maaltijd (0-5) |

### Functions

| Name | Summary |
|---|---|
| [addMaaltijdOnderdeel](add-maaltijd-onderdeel.md) | `fun addMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie om een maaltijdOnderdeel toe te voegen aan de maaltijd |
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Functie om na te gaan of de maaltijd gelijk is aan een opgegeven object |
| [removeMaaltijdOnderdeel](remove-maaltijd-onderdeel.md) | `fun removeMaaltijdOnderdeel(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie om een maaltijdOnderdeel te verwijderen van de maaltijd |
