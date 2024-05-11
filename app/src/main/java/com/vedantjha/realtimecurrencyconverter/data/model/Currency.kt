package com.vedantjha.realtimecurrencyconverter.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "available_currencies")
@Parcelize
data class Currency(
    @PrimaryKey
    @ColumnInfo(name = "CurrencyCode")
    val code: String = "",

    @ColumnInfo(name = "CurrencyName")
    val name: String = ""
): Parcelable
