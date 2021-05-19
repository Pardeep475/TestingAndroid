package mobile.android.testapplication.network

import android.content.Context
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
    var instance: ApiClient? = null

    fun getClient(context: Context): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(1000, TimeUnit.MINUTES)
        httpClient.readTimeout(2, TimeUnit.MINUTES)
        httpClient.writeTimeout(2, TimeUnit.MINUTES)
        httpClient.addInterceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader("Content-Type", "application/json")
            chain.proceed(builder.build())
        }
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)

        try {
            retrofit = Retrofit.Builder()
                    .baseUrl(WebserviceUrls.BASE_URL)
                    .client(httpClient.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                    .build()
        } catch (e: Exception) {
            Toast.makeText(context, "$e", Toast.LENGTH_LONG).show()
        }
        return retrofit!!
    }


    private fun okClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build()
    }


}
