package com.socratesdiaz.prototimer

import com.socratesdiaz.prototimer.data.models.jira.request.JQLRequest
import com.socratesdiaz.prototimer.data.source.remote.jira.JiraApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class JiraApiUnitTest {

    private fun createApi(): JiraApiService? {
        val interceptor = Interceptor { chain -> chain.proceed(chain.request()) }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://colmapp.atlassian.net/rest/api/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(JiraApiService::class.java)
    }

    @Test
    fun `Search for an issue`() {
        val api = createApi()
        api?.search(JQLRequest(jql = "summary ~ \"*\" ORDER BY lastViewed DESC"))
            ?.test()
            ?.assertComplete()
    }
}