[app](../../index.md) / [android.com.what2eat.fragments](../index.md) / [MaaltijdEditFragment](./index.md)

# MaaltijdEditFragment

`class MaaltijdEditFragment : Fragment`

Fragment voor het weergeven van een editscherm van een maaltijd

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdEditFragment()`<br>Fragment voor het weergeven van een editscherm van een maaltijd |

### Properties

| Name | Summary |
|---|---|
| [REQUEST_TAKE_PHOTO](-r-e-q-u-e-s-t_-t-a-k-e_-p-h-o-t-o.md) | `val REQUEST_TAKE_PHOTO: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Request token |
| [application](application.md) | `lateinit var application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)<br>Application |

### Functions

| Name | Summary |
|---|---|
| [onActivityResult](on-activity-result.md) | `fun onActivityResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, resultCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, data: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen wanneer er een Result wordt ontvangen van de Intent voor het nemen van een foto. |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is. Fragment properties worden hier geïnstantieerd. |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`, inflater: `[`MenuInflater`](https://developer.android.com/reference/android/view/MenuInflater.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om het overflow menu weer te geven. Overflowmenu is een delete icon om de maaltijd te verwijderen. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`<br>Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is Setup van DataBinding, RecyclerView, ViewModel Observers, UI ClickListeners, ActionBar |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie wordt gebruikt om de gebruikte menuItem uit het overflowmenu af te handelen. |
