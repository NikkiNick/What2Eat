[app](../../../index.md) / [android.com.what2eat.adapters](../../index.md) / [MaaltijdAdapter](../index.md) / [ViewHolder](./index.md)

# ViewHolder

`class ViewHolder : ViewHolder`

Custom ViewHolder class die gebruikt wordt in de RecyclerView.

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `val binding: MaaltijdItemViewBinding`<br>LayoutBinding die gebruikt wordt door de ViewHolder |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `fun bind(item: `[`Maaltijd`](../../../android.com.what2eat.model/-maaltijd/index.md)`, clickListener: `[`MaaltijdListener`](../../-maaltijd-listener/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt gebruikt om een [Maaltijd](../../../android.com.what2eat.model/-maaltijd/index.md) en [MaaltijdListener](../../-maaltijd-listener/index.md) te binden aan de ViewHolder |

### Companion Object Functions

| Name | Summary |
|---|---|
| [from](from.md) | `fun from(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`ViewHolder`](./index.md)<br>Deze functie wordt gebruikt om de layout te binden aan de ViewHolder |
