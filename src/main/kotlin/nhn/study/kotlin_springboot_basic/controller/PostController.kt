package nhn.study.kotlin_springboot_basic.controller

import nhn.study.kotlin_springboot_basic.dto.UserRequestDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostController {

    @PostMapping("/post-mapping")
    fun postMapping() : String{
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping() : String {
        return "request-mapping"
    }

    // object mapper
    // json -> object
    // object -> json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequestDto): UserRequestDto {
        // json -> object
        print(userRequest)
        return userRequest
    }



}