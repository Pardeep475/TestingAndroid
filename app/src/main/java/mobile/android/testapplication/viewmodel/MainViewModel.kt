package mobile.android.testapplication.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import mobile.android.testapplication.network.AndroidDisposable
import mobile.android.testapplication.network.IApiResponse
import mobile.android.testapplication.network.INetworkResponse
import mobile.android.testapplication.network.NetworkRepo
import mobile.android.testapplication.utils.BaseViewModel

class MainViewModel(application: Application) : BaseViewModel(application), INetworkResponse {

    private var disposable = AndroidDisposable()
    private lateinit var aApiResponse: IApiResponse

    fun initApiResponseListener(apiResponseListener: IApiResponse) {
        aApiResponse = apiResponseListener
    }


    fun fetchData(pageNumber: Int) {
        val networkRepo = NetworkRepo()
        networkRepo.fetchData(
            "", this, fetchDisposable()
            , fetchApiHelper().fetchData(pageNumber)
        )

    }


    override fun OnSuccess(data: LiveData<String>, apiType: String) {
        aApiResponse.OnApiSuccessResponse(data, apiType)
    }

    override fun OnError(error: LiveData<String>, apiType: String) {
        aApiResponse.OnApiErrorResponse(error, apiType)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()

    }

}