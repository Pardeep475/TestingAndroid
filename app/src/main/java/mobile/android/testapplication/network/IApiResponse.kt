package mobile.android.testapplication.network

import androidx.lifecycle.LiveData

interface IApiResponse {
    fun OnApiSuccessResponse(response: LiveData<String>, successType: String = "Parent")
    fun OnApiErrorResponse(error: LiveData<String>, errorType: String = "Parent")
}