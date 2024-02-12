-- liquibase formatted sql

-- changeset om:creating-ability-detail
CREATE TABLE ability_detail (
    id varchar(256) PRIMARY KEY,
    is_hidden BOOLEAN NOT NULL
--    pokemon_details_id varchar(256) REFERENCES pokemon_detail(id)
) collate = utf8mb4_unicode_ci;