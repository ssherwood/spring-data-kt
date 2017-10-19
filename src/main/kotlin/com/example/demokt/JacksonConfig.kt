package com.example.demokt

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JacksonConfig {

    @Bean
    fun kotlinModule() = KotlinModule()

    /**
     * Allows Jackson to marshal JSON without triggering lazy loading
     */
    @Bean
    fun hibernate5Module() = Hibernate5Module()
}