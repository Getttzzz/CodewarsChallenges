package com.codewars.codewarschallenges.di

import android.content.Context
import com.codewars.data.CodewarsBuildConfig
import com.codewars.data.api.CodewarsApi
import com.codewars.data.repository.ChallengeRepositoryImpl
import com.codewars.domain.repository.ChallengeRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val CACHE_MAX_SIZE = 20L * 1024 * 1024

val dataModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        Cache(directory = get<Context>().cacheDir, maxSize = CACHE_MAX_SIZE)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .cache(get())
            .build()
    }

    single {
        GsonConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(CodewarsBuildConfig.BASE_URL)
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get())
            .build()
    }

    single<CodewarsApi> {
        get<Retrofit>().create()
    }

    single<ChallengeRepository> {
        ChallengeRepositoryImpl(get())
    }
}
