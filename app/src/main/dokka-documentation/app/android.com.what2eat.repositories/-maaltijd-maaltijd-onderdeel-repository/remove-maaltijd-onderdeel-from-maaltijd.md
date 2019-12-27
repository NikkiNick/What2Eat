[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdMaaltijdOnderdeelRepository](index.md) / [removeMaaltijdOnderdeelFromMaaltijd](./remove-maaltijd-onderdeel-from-maaltijd.md)

# removeMaaltijdOnderdeelFromMaaltijd

`suspend fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Co-Routine functie voor het verwijderen van een maaltijdOnderdeel van een maaltijd (JOIN table).
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de maaltijd

`maaltijdOnderdeelId` - Id van het maaltijdOnderdeel