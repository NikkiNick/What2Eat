[app](../../index.md) / [android.com.what2eat.repositories](../index.md) / [MaaltijdRepository](index.md) / [getMaaltijdenFromMaaltijdOnderdeel](./get-maaltijden-from-maaltijd-onderdeel.md)

# getMaaltijdenFromMaaltijdOnderdeel

`suspend fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`>?`

Co-Routine functie voor het ophalen van alle maaltijden die een relatie hebben met een
gegeven maaltijdOnderdeel van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd.

### Parameters

`maaltijdOnderdeel_id` - Id van het gegeven maaltijdOnderdeel

**Return**
Lijst van maaltijden

