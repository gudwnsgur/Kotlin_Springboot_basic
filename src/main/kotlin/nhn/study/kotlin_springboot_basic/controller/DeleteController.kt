package nhn.study.kotlin_springboot_basic.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
public class DeleteController {
    // 1. path variable


    // 2. request param
    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name : String,
        @RequestParam age : Int
    ): String {
        return "${name} ${age}"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable name:String,
        @PathVariable age:Int
    ): String {
        return "${name} ${age}"
    }
}