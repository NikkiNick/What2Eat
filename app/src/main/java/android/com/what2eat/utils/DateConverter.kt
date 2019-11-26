package android.com.what2eat.utils

import androidx.room.TypeConverter
//import jdk.nashorn.internal.objects.NativeDate.getTime
import java.util.*


class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        if (dateLong == null) {
            return null
        } else {
            return Date(dateLong)
        }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        if (date == null) {
            return null
        } else {
            return date!!.getTime()?.toLong()
        }
    }
}