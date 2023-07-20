package de.reproducer

import de.reproducer.config.SpringServiceProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SpringServiceProperties::class)
class SpringServiceApplication

fun main(args: Array<String>) {
    runApplication<SpringServiceApplication>(*args)
}
