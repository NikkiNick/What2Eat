[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdMaaltijdOnderdeelRepository](index.md) / [deleteMaaltijdenMaaltijdOnderdelenJoin](./delete-maaltijden-maaltijd-onderdelen-join.md)

# deleteMaaltijdenMaaltijdOnderdelenJoin

`suspend fun deleteMaaltijdenMaaltijdOnderdelenJoin(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Co-Routine functie voor het verwijderen van alle relaties van een gegeven maaltijd (JOIN table).
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de maaltijd