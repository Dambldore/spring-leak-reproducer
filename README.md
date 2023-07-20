# spring-leak-reproducer

This repository is a minimal reproducer for a leak exception coming from netty.
It's using the scheduled functionality to call a function oftent to reproduce it more consistently.

## setup

* start the database (can be done with `docker compose up`, alternatively a postgresql is needed with the credentials matching the `application.yml`)
* start the app (`./mvnw spring-boot:run`)
* after around ~3 minutes, the exception should have been thrown at least once already

## diagnosis

gathered info during reproduction phase:
* the `.reduce()` in the `CommandService` class in line 35 seems to be the faulty line
* exchanging it with a `.collectList().map { l -> l.sum() }` results in no error thrown
