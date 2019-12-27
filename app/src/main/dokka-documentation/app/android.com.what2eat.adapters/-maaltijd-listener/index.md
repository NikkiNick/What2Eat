[app](../../index.md) / [android.com.what2eat.adapters](../index.md) / [MaaltijdListener](./index.md)

# MaaltijdListener

`class MaaltijdListener`

Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
Wanneer de gebruiker op een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) clickt in de RecyclerView wordt de id van de [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) teruggegeven.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdListener(clickListener: (maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)`<br>Constructor voor het aanmaken van een [MaaltijdListener](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [clickListener](click-listener.md) | `val clickListener: (maaltijdId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onClick](on-click.md) | `fun onClick(maaltijd: `[`Maaltijd`](../../android.com.what2eat.model/-maaltijd/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om de id van de [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) terug te geven wanneer een gebruiker een [Maaltijd](../../android.com.what2eat.model/-maaltijd/index.md) gekozen heeft. |
