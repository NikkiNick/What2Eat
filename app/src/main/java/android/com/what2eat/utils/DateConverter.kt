package android.com.what2eat.utils

import androidx.room.TypeConverter
import java.util.*

/**
 * Converter voor het omzetten van Date objecten naar/van Room-databank
 */
class DateConverter {
    /**
     * Functie voor het omzetten van een datum (van Long naar Date)
     * @param dateLong Datum (Long)
     * @return Datum (Date)
     */
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        if (dateLong == null) {
            return null
        } else {
            return Date(dateLong)
        }
    }

    /**
     * Functie voor het omzetten van een datum (van Date naar Long)
     * @param date Datum (Date)
     * @return Datum (Long)
     */
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        if (date == null) {
            return null
        } else {
            return date.getTime()
        }
    }
}