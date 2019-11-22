CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    id   BIGSERIAL NOT NULL,
    username VARCHAR   NOT NULL,
    password varchar not null,
    firstName varchar not null,
    lastName varchar not null,
    email varchar not null,
    birthDate varchar not null,

    PRIMARY KEY (id)
);