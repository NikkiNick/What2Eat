[app](../../index.md) / [android.com.what2eat.injection](../index.md) / [DatabaseModule](./index.md)

# DatabaseModule

`@Module class DatabaseModule`

Database Module voor Dagger dependency injection

### Parameters

`application` - ApplicationContext gebruikt om te initialiseren

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DatabaseModule(application: Application)`<br>Database Module voor Dagger dependency injection |

### Functions

| Name | Summary |
|---|---|
| [provideApplication](provide-application.md) | `fun provideApplication(): Application`<br>Voorzien van Application singleton |
| [provideApplicationContext](provide-application-context.md) | `fun provideApplicationContext(): Context`<br>Voorzien van ApplicationContext singleton |
| [provideDatabaseInstance](provide-database-instance.md) | `fun provideDatabaseInstance(context: Context): `[`MaaltijdDatabase`](../../android.com.what2eat.database/-maaltijd-database/index.md)<br>Voorzien van Database ([MaaltijdDatabase](../../android.com.what2eat.database/-maaltijd-database/index.md)) singleton |
| [provideMaaltijdDao](provide-maaltijd-dao.md) | `fun provideMaaltijdDao(maaltijdDatabase: `[`MaaltijdDatabase`](../../android.com.what2eat.database/-maaltijd-database/index.md)`): `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md)<br>Voorzien van DAO voor maaltijden([MaaltijdDao](../../android.com.what2eat.database/-maaltijd-dao/index.md)) singleton |
| [provideMaaltijdMaaltijdOnderdeelDao](provide-maaltijd-maaltijd-onderdeel-dao.md) | `fun provideMaaltijdMaaltijdOnderdeelDao(maaltijdDatabase: `[`MaaltijdDatabase`](../../android.com.what2eat.database/-maaltijd-database/index.md)`): `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)<br>Voorzien van DAO voor maaltijdMaaltijdOnderdelen([MaaltijdMaaltijdOnderdeelDao](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)) singleton |
| [provideMaaltijdMaaltijdOnderdeelRepo](provide-maaltijd-maaltijd-onderdeel-repo.md) | `fun provideMaaltijdMaaltijdOnderdeelRepo(maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-maaltijd-onderdeel-dao/index.md)`): `[`MaaltijdMaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-maaltijd-onderdeel-repository/index.md)<br>Voorzien van repository voor maaltijdMaaltijdOnderdelen([MaaltijdMaaltijdOnderdeelRepository](../../android.com.what2eat.repositories/-maaltijd-maaltijd-onderdeel-repository/index.md)) singleton |
| [provideMaaltijdOnderdeelDao](provide-maaltijd-onderdeel-dao.md) | `fun provideMaaltijdOnderdeelDao(maaltijdDatabase: `[`MaaltijdDatabase`](../../android.com.what2eat.database/-maaltijd-database/index.md)`): `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)<br>Voorzien van DAO voor maaltijdOnderdelen([MaaltijdOnderdeelDao](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)) singleton |
| [provideMaaltijdOnderdeelRepo](provide-maaltijd-onderdeel-repo.md) | `fun provideMaaltijdOnderdeelRepo(maaltijdOnderdeelDao: `[`MaaltijdOnderdeelDao`](../../android.com.what2eat.database/-maaltijd-onderdeel-dao/index.md)`): `[`MaaltijdOnderdeelRepository`](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md)<br>Voorzien van repository voor maaltijdOnderdelen([MaaltijdOnderdeelRepository](../../android.com.what2eat.repositories/-maaltijd-onderdeel-repository/index.md)) singleton |
| [provideMaaltijdRepo](provide-maaltijd-repo.md) | `fun provideMaaltijdRepo(maaltijdDao: `[`MaaltijdDao`](../../android.com.what2eat.database/-maaltijd-dao/index.md)`): `[`MaaltijdRepository`](../../android.com.what2eat.repositories/-maaltijd-repository/index.md)<br>Voorzien van repository voor maaltijden([MaaltijdRepository](../../android.com.what2eat.repositories/-maaltijd-repository/index.md)) singleton |
