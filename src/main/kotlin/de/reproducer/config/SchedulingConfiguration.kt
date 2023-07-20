package de.reproducer.config

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@ConditionalOnProperty(
    value = ["app.scheduling.enable"], havingValue = "true"
)
@Configuration
@EnableScheduling
class SchedulingConfiguration
