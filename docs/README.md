# PokemonAPI

`PokemonAPI` expose some API endpoints to fetch, create, update and delete the Pokémon Details.

## IDE (Integrated Deveopment Environment)
- Preferable: [JetBrains Intellij IDEA](/docs/tools/ide.md)
- [Visual Studio Code](https://code.visualstudio.com/download)

## Tools (Required)
- [Java](/docs/tools/java.md)  JDK 21
- [Gradle](/docs/tools/gradle.md) v7.4.2

## Library
- [Micronaut](/docs/libs/micronaut.md)
- [Liquibase](/docs/libs/liquibase.md)
- [ULID](/docs/libs/ulid.md)
- YAML
- Data - JPA
- JUnit5
- AssertJ
- Micronaut-Rest-Assured

## Setup Locally
1. Clone the Repository
```bash
git clone https://github.com/omjogani/pokemon-app.git
```

---

2. Start Docker Container
- Start Docker Desktop, not installed? [Download Docker](https://www.docker.com/products/docker-desktop/).

---

3. Spin up Docker Compose
```bash
docker compose up -d
```

---

4. Gradle build
```bash
./gradlew build
```

---

5. Gradle run
```bash
./gradlew run
```

### Changelog
- 0.2
  - Added Database Schema of `pokemon` & `pokemon details`
  - Added CRUD endpoints in Pokemon
- 0.1
  - Project Setup

### Author
> Om Jogani [GitHub](https://github.com/omjogani)

### License
`PokemonAPI` is licensed under MIT Commercial License.