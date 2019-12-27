[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](index.md) / [deleteMaaltijd](./delete-maaltijd.md)

# deleteMaaltijd

`suspend fun deleteMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Co-Routine functie voor het verwijderen van een maaltijd van de Room-databank.
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijd` - Maaltijd dat wordt verwijderd.