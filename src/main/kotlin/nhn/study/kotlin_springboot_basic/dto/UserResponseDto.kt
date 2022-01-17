package nhn.study.kotlin_springboot_basic.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponseDto(
    var result: Result? = null,
    var description: String? = null,

    @JsonProperty("user")
    var userRequest: MutableList<UserRequestDto>? = null
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Result(
    var resultCode: String? = null,
    var resultMessage: String? = null
)

/*
    {
        "result : {
            "result_code" :
            "result_massage" :
        }
        "description" :
        "user" : [
            {
                "name" :
                "age" :
                "email" :
                "phoneNumber" :
            },
            {
                "name" :
                "age" :
                "email" :
                "phoneNumber" :
            }
        ]
    }

 */