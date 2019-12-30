[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdMaaltijdOnderdeelRepository](index.md) / [addMaaltijdOnderdeelToMaaltijd](./add-maaltijd-onderdeel-to-maaltijd.md)

# addMaaltijdOnderdeelToMaaltijd

`suspend fun addMaaltijdOnderdeelToMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Co-Routine functie voor het toevoegen van een maaltijdOnderdeel aan een maaltijd (JOIN table).
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de maaltijd

`maaltijdOnderdeelId` - Id van het maaltijdOnderdeel