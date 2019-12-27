[app](../../index.md) / [android.com.what2eat.activities](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

Globale Activity voor de What2Eat applicatie

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()`<br>Globale Activity voor de What2Eat applicatie |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen wanneer [MainActivity](./index.md) aangemaakt wordt en in CREATED lifecycle state gaat. Hier wordt de layoutBinding geinitialiseerd en de DrawerLayout toegevoegd aan de [MainActivity](./index.md)-layout. |
| [onSupportNavigateUp](on-support-navigate-up.md) | `fun onSupportNavigateUp(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie wordt opgeroepen wanneer de gebruiker de NavigateUp button gebruikt. |
| [setCustomActionBar](set-custom-action-bar.md) | `fun setCustomActionBar(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt door de verschillende fragments voor het instellen van een custom ActionBar titel, alsook het toevoegen van de NavController en  DrawerLayout. |
