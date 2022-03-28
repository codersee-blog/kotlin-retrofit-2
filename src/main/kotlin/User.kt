import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    @JsonProperty("id") val id: Long,
    @JsonProperty("name") val name: String,
    @JsonProperty("age") val age: Int
)