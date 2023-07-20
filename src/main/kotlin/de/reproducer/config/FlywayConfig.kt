package de.reproducer.config

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@ConditionalOnProperty(
    value = ["spring.flyway.enabled"], havingValue = "true"
)
@Configuration
class FlywayConfig(
    private val springServiceProperties: SpringServiceProperties
) {
    @Bean(initMethod = "migrate")
    fun flyway(): Flyway {
        return Flyway(
            Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(
                    springServiceProperties.spring.flyway.url,
                    springServiceProperties.spring.flyway.user,
                    springServiceProperties.spring.flyway.password
                )
        )
    }
}
