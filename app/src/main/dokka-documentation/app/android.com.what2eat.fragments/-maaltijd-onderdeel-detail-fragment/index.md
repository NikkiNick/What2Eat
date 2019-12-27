[app](../../index.md) / [android.com.what2eat.fragments](../index.md) / [MaaltijdOnderdeelDetailFragment](./index.md)

# MaaltijdOnderdeelDetailFragment

`class MaaltijdOnderdeelDetailFragment : Fragment`

Fragment voor het weergeven van detail van een maaltijd

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdOnderdeelDetailFragment()`<br>Fragment voor het weergeven van detail van een maaltijd |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is. Fragment properties worden hier geïnstantieerd. |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om het overflow menu weer te geven. Overflowmenu is een delete icon om het maaltijdOnderdeel te verwijderen. |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?`<br>Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is. Setup van DataBinding, RecyclerView, ViewModel Observers, UI ClickListeners, ActionBar |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: MenuItem): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deze functie wordt gebruikt om de gebruikte menuItem uit het overflowmenu af te handelen. |
