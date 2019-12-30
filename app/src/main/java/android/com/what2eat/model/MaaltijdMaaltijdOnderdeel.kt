package android.com.what2eat.model

import androidx.room.Entity
import androidx.room.Index

/**
 * Model gebruikt voor MaaltijdMaaltijdOnderdeel. Deze klasse vertegenwoordigt de JOIN relaties
 * tussen Maaltijd en MaaltijdOnderdeel
 * @property maaltijdId Id van de maaltijd
 * @property maaltijdOnderdeelId Id van het maaltijdOnderdeel
 */
@Entity(tableName = "table_maaltijdMaaltijdOnderdeel",
        primaryKeys = ["maaltijdId", "maaltijdOnderdeelId"],
        indices = [Index("maaltijdOnderdeelId")])
class MaaltijdMaaltijdOnderdeel(
    var maaltijdId: Long,
    var maaltijdOnderdeelId: Long
)