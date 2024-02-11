-- liquibase formatted sql

-- changeset om:creating-pokemon
CREATE TABLE pokemon (
    id varchar(256) PRIMARY KEY,
    name varchar(256) NOT NULL,
    url varchar(256) NOT NULL
) collate = utf8mb4_unicode_ci;