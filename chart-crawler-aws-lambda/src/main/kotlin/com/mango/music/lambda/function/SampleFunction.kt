package com.mango.music.lambda.function

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class SampleFunction {

    @Bean
    fun reverseString(): (String) -> String {

        return { it.reversed() }
    }
}