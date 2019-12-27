[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdOnderdeelRepository](index.md) / [getAllMaaltijdOnderdelenNotFromMaaltijd](./get-all-maaltijd-onderdelen-not-from-maaltijd.md)

# getAllMaaltijdOnderdelenNotFromMaaltijd

`suspend fun getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`>?`

Co-Routine functie voor het ophalen van alle maaltijdOnderdelen die niet bij een gegeven
maaltijdOnderdeel horen van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdId` - Id van de gegeven maaltijd

**Return**
Lijst van maaltijdOnderdelen

