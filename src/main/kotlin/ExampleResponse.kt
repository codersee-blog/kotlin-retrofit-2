import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExampleResponse(
    @JsonProperty("disclaimer") val disclaimer: String,
    @JsonProperty("chartName") val chartName: String
)