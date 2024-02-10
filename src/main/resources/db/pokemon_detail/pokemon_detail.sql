-- liquibase formatted sql

-- changeset om:creating-pokemon-details
CREATE TABLE pokemon_detail (
    id varchar(256) PRIMARY KEY,
    name varchar(256) NOT NULL,
    url varchar(256) NOT NULL,
    height int NOT NULL,
    weight int NOT NULL,
) collate = utf8mb4_unicode_ci;