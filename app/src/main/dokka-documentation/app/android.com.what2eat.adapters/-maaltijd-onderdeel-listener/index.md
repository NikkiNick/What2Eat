[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdOnderdeelListener](./index.md)

# MaaltijdOnderdeelListener

`class MaaltijdOnderdeelListener`

Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
Wanneer de gebruiker op een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) clickt in de RecyclerView wordt de id van het
[MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) teruggegeven.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelListener(clickListener: (maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)`<br>Constructor voor het aanmaken van de Listener |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: (maaltijdOnderdeelId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onClick](on-click.md) | `fun onClick(maaltijdOnderdeel: `[`MaaltijdOnderdeel`](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om de id van het [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)] terug te geven wanneer een gebruiker een [MaaltijdOnderdeel](../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) gekozen heeft. |
