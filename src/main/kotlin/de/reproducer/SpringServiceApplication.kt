package de.reproducer

import de.reproducer.config.SpringServiceProperties
import io.netty.util.ResourceLeakDetector
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SpringServiceProperties::class)
class SpringServiceApplication

fun main(args: Array<String>) {
    ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED)
    runApplication<SpringServiceApplication>(*args)
}
