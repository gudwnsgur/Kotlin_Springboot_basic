package nhn.study.kotlin_springboot_basic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringbootBasicApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootBasicApplication>(*args)
}
