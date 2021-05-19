package mobile.android.testapplication.network


import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiHelper {
    @GET("list?page=")
    fun fetchData(@Query("page") page : Int): Observable<Response<JsonElement>>
}