
## Restful API in Java/SpringBoot

## OpenAPI document

- [OpenAPI doc](http://localhost:8080/v3/api-docs)

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)
  - ![API](./swagger-ui.png)
  - missing `/auth/login` in Swagger: login to get JWT token

## GraphQL API

- [GraphQL Endpoint](http://localhost:8080/graphiql)
- [GraphQL queries](./graphql-queries.md)

## How to run

Run all the tests
```bash
auto/test
```

Run a specific test:
```bash
./gradlew test --test my.playground.user.UserControllerTest
```

Run the application locally:
```bash
auto/dev
```

### Tech Stack

- [x] Java 17
- [x] SpringBoot 3 (Spring 6)
- [x] PostgreSQL
- [x] Spring Security
- [x] Flyway
- [x] JWT
- [x] Dockerise
- [x] OpenAPI 3
- [x] TestContainers for integration tests
- [x] GraphQL API

### TODO

- [ ] introduce VAVR and refactor in a functional programming way
- [ ] encrypt the database secret
