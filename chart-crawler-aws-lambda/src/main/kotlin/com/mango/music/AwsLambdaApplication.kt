package com.mango.music

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AwsLambdaApplication {
    @Bean
    fun reverseString(): (String) -> String {

        return { it.reversed() }
    }


}

fun main(args: Array<String>) {
    runApplication<AwsLambdaApplication>(*args)


}