RCA

# Tracking Jira Tickets:

## Owner: Om Jogani

# Overview:
No validations on PokemonID (ULID). ID is generated using ULID package and not getting verified.

## What happened:

_Generally, `new ULID().nextULID()` is used to generate ULID but there was no mechanism to verify that it's generated using ULID Package._

1. **What are the symptoms of the incident?**
- It made data inconsistent in the database. It was crashing when someone trid to add same records with same id. because It is not uniquely identified while it's not getting generated using ULID. 

2. **How did we discover it?**
- While writing Unit Tests, tried with "FAKE_ID" on `PokemonService` `addPokemon` method and test was passes (Without Mocking). Which is not allowed while It was possible to feed the same data in the database.

3. **Is this an active incident?**
- No

## What is the impact: (Sev2)

Database was having inconsistent data which can cause the problem while fetching the data based on ID. When There was another service dependent on Pokemon table will face an issue to fetch the data.

1. _Who is impacted?_
- Client was getting affected because It was causing null value for some Pokemons while PokemonDetail is dependent on Pokemon. Such that In some cases it result into 404 not found error on the webpage.

2. _What does the impact look like?_
- Error page on the Client Screen. Despite having the data in the database.

3. Was there work around?
- We were required to have validations while feeding the ID in the database, If it's invalid we can directly throw an exception.

## Timeline

[ 01/02/2024 10:00 AM ] : Issue get identified by **Om Jogani** and informed to the team immediately. 
[ 02/02/2024 10:00 AM ] : Identified root cause and reproduced \
[ 03/02/2024 01:00 PM ] : Solved the issue. \
[ 05/02/2024 02:00 PM ] : Described the issue and wrote RCA. \

# Analysis:

## Root Cause:

_There wasn't validations in the `PokemonService` in `addPokemon` method which validate that ID is generated using ULID. If It's not generated then we must throw an exception like Invalid ID._

1. _What was the root cause of the incident?_
- No Validation at `PokemonService` that pass any String as an ID. While There is no annotation so no compile time error.

2. _Was there anything in the backlog that could have addressed the root cause?_
- More Unit Tests on `PokemonService` helped to identify the actual location of the bug.

3. _Were there any errors that would have been indicative of this issue?_
No, There was no error before the bug occurs.


## Historical Context:

_**STILL NO BLAME**_

_It’s super useful to know how we ended up in this situation and whether we made past decisions that were the right call at the time, but lead to the current situation._

If the problem had caught in TestCases then There might not been any ID related issue.

## What went well:

_Too often on incidents we focus only on what went wrong. It helps to also note things that went well and note any actions that helped reduce time to fix, time to diagnose, time to failure, etc…_

- Able to understand the problem nicely.
- Able to understand exact cause from where it produces.
- Solved within time and was having good solution and well tested.

## Other Open Action Items:

_Non blocking open action items that are needed to follow up for this incident. Any tooling we need to create, documentation that needs to be updated, more thorough fixes that need to be done, or more tests to be written?_

- `addPokemon()` in `PokemonService` required to be modified from where it get produce.