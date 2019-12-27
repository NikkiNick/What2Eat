[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](index.md) / [addMaaltijd](./add-maaltijd.md)

# addMaaltijd

`suspend fun addMaaltijd(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Co-Routine functie voor het toevoegen van een maaltijd aan de Room-databank.
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijd` - Maaltijd dat wordt toegevoegd.

**Return**
Id van de nieuwe maaltijd

