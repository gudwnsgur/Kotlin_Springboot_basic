package nhn.study.kotlin_springboot_basic.controller

import nhn.study.kotlin_springboot_basic.dto.Result
import nhn.study.kotlin_springboot_basic.dto.UserRequestDto
import nhn.study.kotlin_springboot_basic.dto.UserResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutController {

    @PutMapping("/put-mapping")
    fun putMapping():String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequestDto: UserRequestDto): UserResponseDto {
        // 0. UserResponse 생성
        return UserResponseDto().apply {
            // 1. result 생성
            this.result =
                Result().apply {
                    this.resultCode = "OK"
                    this.resultMessage = "성공"
                }
        }.apply {
            // 2. description 생성
            this.description = "~~~~~~"
        }.apply {
            // 3. user MutableList 생성
            val userList = mutableListOf<UserRequestDto>()

            // 3-1. request 받은 userRequestDto 추가
            userList.add(userRequestDto)

            // 3-2. 새로 생성한 userRequestDto
            userList.add(UserRequestDto().apply {
                this.name = "형준혁"
                this.age = 26
                this.email = "gudwnsgur12@naver.com"
                this.address = "구로"
                this.phoneNumber = "010-7332-0546"
            })
            this.userRequest = userList
        }
    }
}