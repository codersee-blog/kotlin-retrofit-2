import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.ResponseBody

class UserService {

    private val retrofit = RetrofitClient.getClient()
    private val userApi = retrofit.create(UserApi::class.java)

    fun successfulUsersResponse() {
        val usersResponse = userApi.getUsers()
            .execute()

        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()

        val body: List<User>? = usersResponse.body()
    }

    fun successfulExampleResponse() {
        val usersResponse = userApi.getResponse()
            .execute()

        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()

        val body: ExampleResponse? = usersResponse.body()

        println(body)
    }


    fun errorUsersResponse() {
        val usersResponse = userApi.getUsers()
            .execute()

        val errorBody: ResponseBody? = usersResponse.errorBody()

        val mapper = ObjectMapper()
        val mappedBody: ErrorResponse? = errorBody?.let { notNullErrorBody ->
            mapper.readValue(notNullErrorBody.toString(), ErrorResponse::class.java)
        }
    }

    fun headersUsersResponse() {
        val usersResponse = userApi.getUsers()
            .execute()

        val headers = usersResponse.headers()
        val customHeaderValue = headers["custom-header"]
    }
}