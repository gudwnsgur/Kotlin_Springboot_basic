package nhn.study.kotlin_springboot_basic.controller

import nhn.study.kotlin_springboot_basic.dto.UserRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    // 1. get 4xx
    // GET localhost:8080/api/response?age=10
    @GetMapping()
    fun getMapping(
        @RequestParam(required = false) age:Int?
    ): ResponseEntity<String> {
        // 코틀린스럽게
        age?.let {
            if(it < 20) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("미성년자입니다.")
            }
            return ResponseEntity.status(HttpStatus.OK).body("OK")
        }?: kotlin.run {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age가 null입니다.")
        }

        /* 자바스럽게
        // 1. age == null -> 400 error
        if(age == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age가 null입니다.")
        }
        // 2. age < 20 -> 400 error
        if(age < 20) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("미성년자입니다.")
        }

        return ResponseEntity.status(HttpStatus.OK).body("OK")
         */
    }

    // 2. post 200
    @PostMapping()
    fun postMapping(
        @RequestBody userRequestDto: UserRequestDto?
    ): ResponseEntity<UserRequestDto>  // ResponseEntity<Any>
    {
        // object mapper -> object -> json
        return ResponseEntity.status(HttpStatus.OK).body(userRequestDto)
    }

    // 3. put 201
    @PutMapping()
    fun putMapping(@RequestBody userRequestDto: UserRequestDto?): ResponseEntity<UserRequestDto> {
        // 1. 기존 데이터가 없어 새로 생성할 경우
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequestDto)
    }


    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Nothing> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}