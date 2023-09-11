package com.mango

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MusicChartAppApplication

fun main(args: Array<String>) {
    runApplication<MusicChartAppApplication>(*args)
}