package com.socratesdiaz.prototimer

import com.socratesdiaz.prototimer.data.models.jira.request.JQLRequest
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class JiraApiUnitTest {

    private fun createApi(): JiraApiService? {
        val interceptor = Interceptor { chain ->
            val request = chain.request()
            request.newBuilder()
                .header("Authorization", "Basic ${BuildConfig.apiKey}")
                .build()
            chain.proceed(request)
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://colmapp.atlassian.net/rest/api/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(JiraApiService::class.java)
    }

    @Test
    fun `Search for an issue`() {
        val api = createApi()
        api?.search("Basic ${BuildConfig.apiKey}", JQLRequest(jql = "summary ~ \"CC*\" ORDER BY lastViewed DESC"))
            ?.test()
            ?.assertComplete()
    }
}