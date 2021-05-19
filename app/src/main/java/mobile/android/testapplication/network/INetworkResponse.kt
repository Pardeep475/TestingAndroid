package mobile.android.testapplication.network

import androidx.lifecycle.LiveData

interface INetworkResponse {
    fun OnSuccess(data: LiveData<String>, apiType: String)
    fun OnError(error: LiveData<String>, apiType: String)
}