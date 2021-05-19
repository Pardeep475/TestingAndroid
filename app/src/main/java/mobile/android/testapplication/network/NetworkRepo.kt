package mobile.android.testapplication.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class NetworkRepo {

    fun fetchData(apiType: String, networkResponse: INetworkResponse, disposable: AndroidDisposable
                  , requestBody: Observable<Response<JsonElement>>) {

        var data: MutableLiveData<String> = MutableLiveData()
        disposable.add(
                requestBody
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (it.isSuccessful) {
                                data.value = it.body().toString()
                                networkResponse.OnSuccess(data, apiType)
                                Log.e("network_response", it.body().toString() + "")
                            } else {
                                data.value = "Something went wrong"
                                networkResponse.OnError(data, apiType)
                            }
                        }, {
                            data.value = it.message.toString()
                            networkResponse.OnError(data, apiType)
                            it.message?.let { it1 -> Log.e("network_response", it1) }
                        })
        )


    }
}