package mobile.android.testapplication.network


import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

@JvmSuppressWildcards
interface ApiHelper {

//    @POST(WebserviceUrls.APP_CONFIGRATION_API)
//    fun fetchData(): Observable<Response<JsonElement>>

    @GET("list?page=")
    fun fetchData(@Query("page") page : Int): Observable<Response<JsonElement>>

//    @POST(WebserviceUrls.LOGIN_API)
//    fun getUserLogin(@Body loginRetroBean: LoginRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SOCIAL_LOGIN_API)
//    fun getUserSocialLogin(@Body socialRetroBean: SocialRetroBean): Observable<Response<JsonElement>>
//
//
//    @POST(WebserviceUrls.FORGOT_PASSWORD_API)
//    fun sendForgotPasswordLink(@Body forgotPasswordRetroBean: ForgotPasswordRetroBean): Observable<Response<JsonElement>>
//
//
//    @POST(WebserviceUrls.REGISTER_API)
//    fun getUserRegister(@Body registerRetroBean: RegisterRetroBean): Observable<Response<JsonElement>>
//
//
//    @POST(WebserviceUrls.CHANGE_PASSWORD_API)
//    fun ChangePassword(@Body changePasswordRetroBean: ChangePasswordRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.LOGOUT_API)
//    fun LogoutUser(@Body logoutRetroBean: LogoutRetroBean): Observable<Response<JsonElement>>
//
//
//    @POST(WebserviceUrls.EDIT_PROFILE_API)
//    fun EditProfileUserName(@Body editUserNameRetroBean: EditUserNameRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.EDIT_PROFILE_API)
//    fun EditProfileNumber(@Body editNumberRetroBean: EditNumberRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.USER_ADDRESSES_API)
//    fun FetchAllUserAddress(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.REMOVE_USER_ADDRESSES_API)
//    fun RemoveUserAddress(@Body removeAddressRetroBean: RemoveAddressRetroBean): Observable<Response<JsonElement>>
//
//    //    save user address
//    @POST(WebserviceUrls.SAVE_ADDRESSES_API)
//    fun SaveUserAddress(@Body saveAddressRetroBean: SaveAddressRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_ADDRESSES_API)
//    fun EditUserAddress(@Body editAddressRetroBean: EditAddressRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.REMOVE_VEHICLE_API)
//    fun RemoveVehicle(@Body removeVehicleRetroBean: RemoveVehicleRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_VEHICLE_API)
//    fun SaveUserVehicle(@Body saveVehicleRetroBean: SaveVehicleRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_VEHICLE_API)
//    fun EditUserVehicle(@Body editVehicleRetroBean: EditVehicleRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_USER_VEHICLE_API)
//    fun FetchAllUserVehicle(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_PACKAGES_API)
//    fun GetWashPackagesList(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_ADDONS_API)
//    fun GetAddONsList(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_PROMO_CODE_API)
//    fun GetPromoCodes(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CHECK_ADDRESS_DISTANCE_API)
//    fun CheckAddressDistance(@Body checkAddressDistanceRetroBean: CheckAddressDistanceRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CONFIRM_APPOINTMENT_API)
//    fun ConfirmAppointment(@Body confirmAppointmentBean: ConfirmAppointmentBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CONFIRM_APPOINTMENT_API)
//    fun confirmAppointment(@Body makePaymentConfirmAppointmentBean: MakePaymentConfirmAppointmentBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_APPOINTMENT_API)
//    fun SaveAppointment(@Body saveAppointmentBean: SaveAppointmentBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_APPOINTMENT_API)
//    fun SaveAppointmentWithPromoCode(@Body saveAppointmentBean: SaveAppointmentPromoCodeBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_APPOINTMENT_API)
//    fun getAppointments(@Body appointmentRetroBean: AppointmentRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CANCEL_APPOINTMENT_API)
//    fun cancelAppointment(@Body cancelAppointmentDataBean: CancelAppointmentDataBean): Observable<Response<JsonElement>>
//
//    @POST("getAppointment/{id}")
//    fun getAppointmentsInfoByID(@Path("id") userid: String): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.RESCHEDULE_APPOINTMENT_API)
//    fun rescheduleAppointment(@Body rescheduleAppointmentDataBean: RescheduleAppointmentDataBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CHECK_CHARGES_API)
//    fun checkAppointmentStatus(@Body checkAppointmentStatusRetroBean: CheckAppointmentStatusRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_RATING_API)
//    fun giveReviewAndRating(@Body reviewandRatingRetroBean: ReviewandRatingRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.SAVE_CARDS_API)
//    fun SaveCard(@Body saveCardRetroBean: SaveCardRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_CARDS_API)
//    fun getCards(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_VEHICLE_MAKER_API)
//    fun getVehicleMaker(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_VEHICLE_MAKER_MODEL_API)
//    fun getVehicleModel(@Body vehicleModelRetroBean: VehicleModelRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.PAY_FOR_APPOINTMENT_API)
//    fun payPastAppointment(@Body pastAppointmentBeans: PastAppointmentBeans): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_WEEKLY_DISCOUNT_API)
//    fun getWeeklyDiscount(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CHANGE_CLAIM_REWARD_STATUS_API)
//    fun changeclaimrewardStatus(@Body claimRewardStatusRetroBean: ClaimRewardStatusRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.CHECK_DISTANCE)
//    fun checkUserAddressDistance(@Body checkAddressDataBean: CheckAddressDataBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_ADDRESS_TAG_API)
//    fun getaddressTag(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_NOTIFICATIONS_API)
//    fun fetchNotifications(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.TIME_SLOT_API)
//    fun getTimeSlot(@Body timeSlot: TimeSlotDataBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.DATE_SLOT_API)
//    fun getDateSlot(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_FULL_ADDRESS_BYTAG_ID_API)
//    fun getFullAddressByTagID(@Body getAddressByTagIdRetroBean: GetAddressByTagIdRetroBean): Observable<Response<JsonElement>>
//
//    @GET(WebserviceUrls.GET_PROFILE_API)
//    fun getUserProfile(): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.GET_BANNER_IMAGE)
//    fun getBannerImage(@Body bannerImageBean: BannerImageBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.PAST_BOOKING_PAY)
//    fun postPastBookingPay(@Body pastBookingPayBean: PastBookingPayBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.EMAIL_RESEND)
//    fun postEmailResend(@Body ForgotPasswordRetroBean: ForgotPasswordRetroBean): Observable<Response<JsonElement>>
//
//    @POST(WebserviceUrls.EDIT_APOINTMENT_API)
//    fun editAppointment(@Body editAppointmentDataBean: EditAppointmentDataBean): Observable<Response<JsonElement>>
}