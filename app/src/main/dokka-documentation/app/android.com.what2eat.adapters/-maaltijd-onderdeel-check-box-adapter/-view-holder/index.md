[app](../../../index.md) / [android.com.what2eat.adapters](../../index.md) / [MaaltijdOnderdeelCheckBoxAdapter](../index.md) / [ViewHolder](./index.md)

# ViewHolder

`class ViewHolder : ViewHolder`

Custom ViewHolder class die gebruikt wordt in de RecyclerView.

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `val binding: MaaltijdonderdeelCheckboxItemViewBinding`<br>LayoutBinding die gebruikt wordt door de ViewHolder |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `fun bind(item: `[`MaaltijdOnderdeel`](../../../android.com.what2eat.model/-maaltijd-onderdeel/index.md)`, clickListener: `[`MaaltijdOnderdeelListener`](../../-maaltijd-onderdeel-listener/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om een [MaaltijdOnderdeel](../../../android.com.what2eat.model/-maaltijd-onderdeel/index.md) en [MaaltijdOnderdeelListener](../../-maaltijd-onderdeel-listener/index.md) te binden aan de ViewHolder |

### Companion Object Functions

| Name | Summary |
|---|---|
| [from](from.md) | `fun from(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`ViewHolder`](./index.md)<br>Deze functie wordt gebruikt om de layout te binden aan de ViewHolder |
