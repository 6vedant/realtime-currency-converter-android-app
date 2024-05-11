package com.vedantjha.realtimecurrencyconverter.di

import com.vedantjha.realtimecurrencyconverter.CurrencyConverterApplication
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterDao
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
//    @ViewModelScoped
//    @Provides
//    fun providesUserDetailUseCase(repository: UserDetailRepository) : UserDetailUseCase = UserDetailUseCase(repository)

    @Singleton
    @Provides
    fun providesUserDetailRepository() : CurrencyConverterDao {
        val db = CurrencyConverterRoomDatabase.getDatabase(CurrencyConverterApplication.instance)
        return  db.currencyConverterDao()
    }

//    @ViewModelScoped
//    @Provides
//    fun providesUserViewModel(useCase: UserDetailUseCase): UserViewModel = UserViewModel(useCase)

}