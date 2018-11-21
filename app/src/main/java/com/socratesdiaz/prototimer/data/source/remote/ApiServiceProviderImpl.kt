package com.socratesdiaz.prototimer.data.source.remote

import com.socratesdiaz.prototimer.BuildConfig
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServiceProviderImpl: ApiServiceProvider {
    override fun provideJiraApiService(): JiraApiService {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Authorization", "Basic ${BuildConfig.apiKey}")
                .build()
            return@Interceptor chain.proceed(request)
        }

        val httpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.jiraClientUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(JiraApiService::class.java)
    }
}