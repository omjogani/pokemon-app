-- liquibase formatted sql

-- changeset om:creating-ability
CREATE TABLE ability (
    id varchar(256) PRIMARY KEY,
    name varchar(256) NOT NULL,
    url varchar(256) NOT NULL,
    ability_detail_id varchar(256) REFERENCES ability_detail(id)
) collate = utf8mb4_unicode_ci;