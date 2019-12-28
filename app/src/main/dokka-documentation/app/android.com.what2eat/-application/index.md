[app](../../index.md) / [android.com.what2eat](../index.md) / [Application](./index.md)

# Application

`class Application : `[`Application`](https://developer.android.com/reference/android/app/Application.html)

Deze Application wordt gebruikt doorheen de applicatie waarbij de [InjectionGraph](../../android.com.what2eat.injection/-injection-graph/index.md) geinitialiseerd wordt
voor dependency injection

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Application()`<br>Deze Application wordt gebruikt doorheen de applicatie waarbij de [InjectionGraph](../../android.com.what2eat.injection/-injection-graph/index.md) geinitialiseerd wordt voor dependency injection |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deze functie wordt opgeroepen wanneer de Application aangemaakt wordt. Hierbij wordt de [InjectionGraph](../../android.com.what2eat.injection/-injection-graph/index.md) geinitialiseerd. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [component](component.md) | `lateinit var component: `[`InjectionGraph`](../../android.com.what2eat.injection/-injection-graph/index.md) |
