package mobile.android.testapplication.utils

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import mobile.android.testapplication.network.AndroidDisposable
import mobile.android.testapplication.network.ApiClient
import mobile.android.testapplication.network.ApiHelper

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private var apiInterface: ApiHelper = ApiClient.getClient(application).create(ApiHelper::class.java)

    private var disposable = AndroidDisposable()

    init {
        fetchApiHelper()
    }
    fun fetchApiHelper(): ApiHelper {
        return apiInterface
    }

    fun fetchDisposable(): AndroidDisposable {
        return disposable
    }

}