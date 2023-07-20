package de.reproducer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("commands")
data class Command(
    @Id
    var id: UUID?,
    var capacity: Int?
)
