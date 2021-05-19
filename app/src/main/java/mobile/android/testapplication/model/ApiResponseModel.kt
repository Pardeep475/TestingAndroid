package mobile.android.testapplication.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

class ApiResponseModel(elements: Collection<APIResponseModelElement>) : ArrayList<APIResponseModelElement>(elements) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = ApiResponseModel(klaxon.parseArray<APIResponseModelElement>(json)!!)
    }
}

data class APIResponseModelElement (
    val id: String,
    val author: String,
    val width: Long,
    val height: Long,
    val url: String,
    val download_url: String
)
