package nhn.study.kotlin_springboot_basic.controller.get

import nhn.study.kotlin_springboot_basic.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // REST API Controller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello() : String {
        return "hello world"
    }

    // PathVariable 으로 값 받기
    @GetMapping("/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable(value = "name") _name:String, @PathVariable age:Int): String {
        println("${_name} ${age}")
        return "${age}살 ${_name}"
    }

    // RequestParam 으로 값 받기
    @GetMapping("/query-param")
    fun queryParam (
        @RequestParam(value = "name") _name:String,
        @RequestParam age:Int) : String{
        println("${_name} : ${age}")
        return "${age}살 ${_name}"
    }


    // RequestParam 으로 객체 받기
    // UserRequest : name, age, address, email
    @GetMapping("/query-param/object")
    fun queryParamObject(userRequest: UserRequest):UserRequest{
        println(userRequest)
        return userRequest
    }

    // RequestParam 으로 map 받기
    @GetMapping("/query-param/map")
    fun queryParamMap(@RequestParam map : Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }

}