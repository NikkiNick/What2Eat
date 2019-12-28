[app](../../index.md) / [android.com.what2eat.viewmodels](../index.md) / [MaaltijdDetailViewModel](index.md) / [addMaaltijdOnderdelenToMaaltijd](./add-maaltijd-onderdelen-to-maaltijd.md)

# addMaaltijdOnderdelenToMaaltijd

`fun addMaaltijdOnderdelenToMaaltijd(maaltijdOnderdeelIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

CoRoutine launcher die een Array van maaltijdOnderdeelIds kan verbinden met de huidige maaltijd
in de Room-databank. Er wordt voor elk id een relatie aangemaakt (JOIN table) tussen de maaltijd en
het maaltijdOnderdeel.

**See Also**

[MaaltijdMaaltijdOnderdeelRepository.addMaaltijdOnderdeelToMaaltijd](../../android.com.what2eat.repositories/-maaltijd-maaltijd-onderdeel-repository/add-maaltijd-onderdeel-to-maaltijd.md)

