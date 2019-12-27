[app](../../index.md) / [android.com.what2eat.database](../index.md) / [MaaltijdDatabase](./index.md)

# MaaltijdDatabase

`abstract class MaaltijdDatabase : RoomDatabase`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaaltijdDatabase()` |

### Properties

| Name | Summary |
|---|---|
| [maaltijdDao](maaltijd-dao.md) | `abstract val maaltijdDao: `[`MaaltijdDao`](../-maaltijd-dao/index.md) |
| [maaltijdMaaltijdOnderdeelDao](maaltijd-maaltijd-onderdeel-dao.md) | `abstract val maaltijdMaaltijdOnderdeelDao: `[`MaaltijdMaaltijdOnderdeelDao`](../-maaltijd-maaltijd-onderdeel-dao/index.md) |
| [maaltijdOnderdeelDao](maaltijd-onderdeel-dao.md) | `abstract val maaltijdOnderdeelDao: `[`MaaltijdOnderdeelDao`](../-maaltijd-onderdeel-dao/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `fun getInstance(context: Context): `[`MaaltijdDatabase`](./index.md) |
