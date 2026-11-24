# Lab 8: Spring Data JPA and PostgreSQL

JDK 24, PostgreSQL (`event_db`), Gradle[cite: 1, 10].
Env: `DB_USER`, `DB_PASSWORD`[cite: 1].
Run: `ClinicApplication` или `./gradlew bootRun` (`http://localhost:8080`)[cite: 1, 5].

Endpoints:
- GET /api/events (?title=...)[cite: 1]
- GET /api/events/{id}[cite: 1]
- POST /api/events[cite: 1]
- PUT /api/events/{id}[cite: 1]
- DELETE /api/events/{id}[cite: 1]

POST JSON:
{"title": "Math Quiz", "location": "Room 101"}[cite: 1]
