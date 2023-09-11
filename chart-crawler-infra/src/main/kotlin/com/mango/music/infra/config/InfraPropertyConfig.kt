package com.mango.music.infra.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
class InfraPropertyConfig {


    @Profile("develop")
    @PropertySource("classpath:application-develop.properties")
    class InfraDevelopProperties {
        @Bean
        fun infraPropertyConfig(): PropertySourcesPlaceholderConfigurer {
            return PropertySourcesPlaceholderConfigurer()
        }
    }


    @Profile("local")
    @PropertySource("classpath:application-local.properties")
    class InfraLocalProperties {
        @Bean
        fun infraPropertyConfig(): PropertySourcesPlaceholderConfigurer {
            return PropertySourcesPlaceholderConfigurer()
        }
    }

}