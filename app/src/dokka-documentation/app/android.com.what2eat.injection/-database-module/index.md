[app](../../index.md) / [android.com.what2eat.injection](../index.md) / [DatabaseModule](./index.md)

# DatabaseModule

`@Module class DatabaseModule`

Database Module voor Dagger dependency injection

### Parameters

`application` - ApplicationContext gebruikt om te initialiseren

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DatabaseModule(application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)`<br>Database Module voor Dagger dependency injection |

### Functions

| Name | Summary |
|---|---|
| [provideApplication](provide-application.md) | `fun provideApplication(): `[`Application`](https://developer.android.com/reference/android/app/Application.html)<br>Voorzien van Application singleton |
| [provideApplicationContext](provide-application-context.md) | `fun provideApplicationContext(): `[`Context`](https://developer.android.com/reference/android/content/Context.html)<br>Voorzien van ApplicationContext singleton |
