[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdOnderdeelRepository](index.md) / [getMaaltijdOnderdelenFromMaaltijd](./get-maaltijd-onderdelen-from-maaltijd.md)

# getMaaltijdOnderdelenFromMaaltijd

`suspend fun getMaaltijdOnderdelenFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`

Co-Routine functie voor het ophalen van alle maaltijdOnderdelen van een gegeven maaltijdOnderdeel
van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de gegeven maaltijd

**Return**
Lijst van maaltijdOnderdelen

