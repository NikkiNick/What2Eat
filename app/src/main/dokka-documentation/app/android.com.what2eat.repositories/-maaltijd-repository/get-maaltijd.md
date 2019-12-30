[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](index.md) / [getMaaltijd](./get-maaltijd.md)

# getMaaltijd

`suspend fun getMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`?`

Co-Routine functie voor het ophalen van een bepaalde maaltijd van de Room-databank.
Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de gevraagde maaltijd

**Return**
Maaltijd

