[app](../../index.md) / [android.com.what2eat.fragments](../index.md) / [MaaltijdOnderdeelSelectFragment](./index.md)

# MaaltijdOnderdeelSelectFragment

`class MaaltijdOnderdeelSelectFragment : Fragment`

[Fragment](#) voor een maaltijdonderdeeloverzicht met multiple selection

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelSelectFragment()`<br>[Fragment](#) voor een maaltijdonderdeeloverzicht met multiple selection |

### Properties

| Name | Summary |
|---|---|
| [tempCheckedIds](temp-checked-ids.md) | `val tempCheckedIds: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie die wordt opgeroepen wanneer het [Fragment](#) aangemaakt wordt en in CREATED lifecycle state is. Fragment properties worden hier geïnstantieerd. |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`, inflater: `[`MenuInflater`](https://developer.android.com/reference/android/view/MenuInflater.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om het overflow menu weer te geven. Overflowmenu is een delete icon om alle maaltijden te verwijderen. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`<br>Functie die wordt opgeroepen wanneer het [Fragment](#) aangemaakt wordt en in CREATED lifecycle state is. |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie wordt gebruikt om de gebruikte [MenuItem](https://developer.android.com/reference/android/view/MenuItem.html) uit het overflowmenu af te handelen. |
| [onStart](on-start.md) | `fun onStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
