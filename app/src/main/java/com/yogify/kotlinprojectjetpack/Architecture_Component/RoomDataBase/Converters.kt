package com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromDatetoLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }
}