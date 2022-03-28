import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("users")
    fun getUsers(): Call<List<User>>

    // Works exactly the same, as above
    @HTTP(method = "GET", path = "users")
    fun httpUsers(): Call<List<User>>

    @POST("users")
    fun postUsers(): Call<List<User>>

    @PUT("users")
    fun putUsers(): Call<List<User>>

    @PATCH("users")
    fun patchUsers(): Call<List<User>>

    @DELETE("users")
    fun deleteUsers(): Call<List<User>>

    @DELETE("users")
    fun failingDeleteUsers(@Body user: User): Call<User>

    @HTTP(method = "DELETE", path = "users", hasBody = true)
    fun workingDeleteUsers(@Body user: User): Call<User>

    @OPTIONS("users")
    fun optionsUsers(): Call<List<User>>

    // Must be Void
    @HEAD("users")
    fun headUsers(): Call<Void>

    // Replaces the BASE_URL
    @GET("http://localhost:8090/v3/users")
    fun getUsersV3(): Call<List<User>>

    @GET
    fun getUsersDynamic(@Url url: String): Call<List<User>>

    @GET("users/{userId}")
    fun getUserById(@Path("userId") userId: Int): Call<User>

    @GET("users?sort_order=asc")
    fun getUsersStaticQueryParam(): Call<List<User>>

    @GET("users")
    fun getUsersDynamicQueryParam(@Query("sort_order") order: String): Call<List<User>>

    @GET("users")
    fun getUsersDynamicQueryMap(@QueryMap parameters: Map<String, String>): Call<List<User>>

    @Headers("User-Agent: codersee-application")
    @GET("users")
    fun getUsersSingleStaticHeader(): Call<List<User>>

    @Headers(
        value = [
            "User-Agent: codersee-application",
            "Custom-Header: my-custom-header"
        ]
    )
    @GET("users")
    fun getUsersMultipleStaticHeaders(): Call<List<User>>

    @GET("users")
    fun getUsersDynamicHeader(@Header("Authorization") token: String): Call<List<User>>

    @GET("users")
    fun getUsersHeaderMap(@HeaderMap headers: Map<String, String>): Call<List<User>>

    @POST("users")
    fun postUsersWithPayload(@Body user: User): Call<User>

    @FormUrlEncoded
    @POST("users")
    fun postUsersFormUrlEncoded(@Field("field_one") fieldOne: String): Call<User>

    @Multipart
    @POST("users")
    fun postUsersMultipart(@Part("something") partOne: RequestBody): Call<User>
}