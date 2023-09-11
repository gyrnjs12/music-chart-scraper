package com.mango.music.infra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = ["com.mango.music"])
class CrawlerInfraConfig