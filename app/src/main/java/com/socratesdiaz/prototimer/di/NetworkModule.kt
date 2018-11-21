package com.socratesdiaz.prototimer.di

import com.socratesdiaz.prototimer.BuildConfig
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val MODULE_NAME = "Network Module"

val networkModule = Kodein.Module(MODULE_NAME, false) {
    bind<Interceptor>() with singleton { getInterceptor() }
    bind<OkHttpClient>() with singleton { getOkHttpClient(instance()) }
    bind<Retrofit>() with singleton { getRetrofit(instance()) }
    bind<JiraApiService>() with singleton { getApiService(instance()) }
}

private fun getInterceptor() = Interceptor { chain ->
    val request = chain.request().newBuilder()
        .header("Authorization", "Basic ${BuildConfig.apiKey}")
        .build()
    return@Interceptor chain.proceed(request)
}

private fun getOkHttpClient(interceptor: Interceptor) = OkHttpClient.Builder()
    .addNetworkInterceptor(interceptor)
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

private fun getRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.jiraClientUrl)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

private fun getApiService(retrofit: Retrofit) = retrofit.create(JiraApiService::class.java)