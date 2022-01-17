package nhn.study.kotlin_springboot_basic.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import lombok.Data

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequestDto(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,

   // @JsonProperty(value = "phone_number")
    var phoneNumber: String? = null
)
