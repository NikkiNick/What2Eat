[app](../../index.md) / [android.com.what2eat.network](../index.md) / [RecipeData](./index.md)

# RecipeData

`@JsonClass(true) data class RecipeData : `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html)

### Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | `companion object Companion : Parceler<`[`RecipeData`](./index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecipeData(parcel: `[`Parcel`](https://developer.android.com/reference/android/os/Parcel.html)`)`<br>`RecipeData(naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, image_url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, remote_site_url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, ingredienten: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?)` |

### Properties

| Name | Summary |
|---|---|
| [image_url](image_url.md) | `val image_url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [ingredienten](ingredienten.md) | `val ingredienten: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [naam](naam.md) | `val naam: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [remote_site_url](remote_site_url.md) | `val remote_site_url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(source: `[`Parcel`](https://developer.android.com/reference/android/os/Parcel.html)`): `[`RecipeData`](./index.md) |
| [write](write.md) | `fun `[`RecipeData`](./index.md)`.write(dest: `[`Parcel`](https://developer.android.com/reference/android/os/Parcel.html)`, flags: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
