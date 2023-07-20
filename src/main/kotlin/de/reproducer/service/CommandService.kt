package de.reproducer.service

import de.reproducer.persistence.CommandRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class CommandService(
    val repository: CommandRepository
) {
    @Scheduled(fixedDelayString = "100")
    fun createdCommandCheck() {
        checkAndHandleCreatedCommands().block(
            Duration.ofMillis(300000)
        )
    }

    fun checkAndHandleCreatedCommands(): Mono<Long> {
        return Mono
            .zip(
                repository.count(),
                getWithCapacity()
            )
            .map { t2 -> t2.t1 - t2.t2 }

    }

    fun getWithCapacity(): Mono<Int> {
        return repository
            .findAll()
            .map { c -> c.capacity!! }
            // this is the faulty line
            .reduce { c1, c2 ->
                c1 + c2
            }
            // it can instead be done with a .collectList().map { l -> l.sum() } and won't cause an error then
    }
}
