CREATE SEQUENCE hibernate_sequence2;

CREATE TABLE profile2
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    password varchar not null,

    PRIMARY KEY (id)
);