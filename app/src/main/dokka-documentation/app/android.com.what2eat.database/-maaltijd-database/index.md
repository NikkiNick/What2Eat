[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdDatabase](./index.md)

# MaaltijdDatabase

`abstract class MaaltijdDatabase : RoomDatabase`

Room database voor maaltijden, maaltijdonderdelen en een JOIN table voor many-to-many relaties

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDatabase()`<br>Room database voor maaltijden, maaltijdonderdelen en een JOIN table voor many-to-many relaties |

### Properties

| Name | Summary |
|---|---|
| [maaltijdDao](maaltijd-dao.md) | `abstract val maaltijdDao: `[`MaaltijdDao`](../-maaltijd-dao/index.md)<br>DAO voor Room-operaties voor maaltijden |
| [maaltijdMaaltijdOnderdeelDao](maaltijd-maaltijd-onderdeel-dao.md) | `abstract val maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../-maaltijd-maaltijd-onderdeel-dao/index.md)<br>DAO voor Room-operaties voor many-to-many relaties tussen maaltijden en maaltijdOnderdelen |
| [maaltijdOnderdeelDao](maaltijd-onderdeel-dao.md) | `abstract val maaltijdOnderdeelDao: `[`MaaltijdOnderdeelDao`](../-maaltijd-onderdeel-dao/index.md)<br>DAO voor Room-operaties voor maaltijdOnderdelen |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`MaaltijdDatabase`](./index.md)<br>Functie die de database instantie teruggeeft. Als de database reeds bestaat, wordt deze teruggegeven. Zoniet wordt deze eerst geïnstantieerd. |
