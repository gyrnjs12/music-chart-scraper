package com.mango.music.infra.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
@Import(InfraPropertyConfig::class)
class InfraDatabaseConfig(
    @Value("\${database.username}") val username: String,
    @Value("\${database.password}") val password: String,
    @Value("\${database.url}") val url: String,
    @Value("\${database.driver-class}") val driverClass: String,
) {

    @Bean
    fun dataSource(): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = url
        hikariConfig.driverClassName = driverClass
        hikariConfig.username = username
        hikariConfig.password = password

        return HikariDataSource(hikariConfig)
    }

    @Bean
    fun transactionManager(dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

}