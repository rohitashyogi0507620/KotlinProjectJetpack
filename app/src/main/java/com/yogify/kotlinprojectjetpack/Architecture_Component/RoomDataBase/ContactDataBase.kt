package com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class) // Used For Type Converters

abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    companion object {

        // Migration Object for Data Base to Add New Colomun
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isactive INTEGER NOT NULL DEFAULT(1)")
            }

        }


        //   @Volatile  If Something is changed then every thred get updated value Automatic

        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDataBase(context: Context): ContactDataBase {
            if (INSTANCE == null) {
                // Create Only single , if two class trying to create this at same time , This is Called Locking
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context,
                            ContactDataBase::class.java,
                            "ContactDataBase"
                        )
                            .addMigrations(migration_1_2)
                            .build()
                }

            }
            return INSTANCE!!
        }
    }
}