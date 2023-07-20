package de.reproducer.persistence

import de.reproducer.model.Command
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommandRepository : ReactiveCrudRepository<Command, UUID>
