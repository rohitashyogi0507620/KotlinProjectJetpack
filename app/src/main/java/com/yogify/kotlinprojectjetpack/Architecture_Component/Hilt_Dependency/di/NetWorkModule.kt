package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di

import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserConstant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetWorkModule {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun previdesUserAPI(retrofit: Retrofit): UserAPI {
        return  retrofit.create(UserAPI::class.java)
    }
}