package com.vedantjha.realtimecurrencyconverter.data.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vedantjha.realtimecurrencyconverter.data.model.Currency
import com.vedantjha.realtimecurrencyconverter.utils.Constant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Currency::class], version = 2, exportSchema = false)
public abstract class CurrencyConverterRoomDatabase: RoomDatabase() {
    abstract fun currencyConverterDao(): CurrencyConverterDao

    companion object {
        // singleton object for WordRoomDatabase
        @Volatile
        private var instance: CurrencyConverterRoomDatabase? = null

        fun getDatabase(context: Context): CurrencyConverterRoomDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val newInstance = Room.databaseBuilder(context.applicationContext, CurrencyConverterRoomDatabase::class.java,
                    "currency_room_db")
                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build()
                instance = newInstance
                Log.d("CURRENCY", "room db created: "+ instance?.currencyConverterDao())

                return newInstance
            }
        }
        // Migration from version 1 to version 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE available_currencies ADD COLUMN CurrencyCode CurrencyCode NOT NULL DEFAULT ''")
            }
        }
    }
}