ALTER TABLE profile
    RENAME COLUMN name TO username;

ALTER TABLE profile
    ADD COLUMN password  varchar,
    ADD COLUMN firstName varchar,
    ADD COLUMN lastName  varchar,
    ADD COLUMN email     varchar,
    ADD COLUMN birthDate varchar;


ALTER TABLE profile
    ALTER COLUMN password SET NOT NULL,
    ALTER COLUMN firstName SET NOT NULL,
    ALTER COLUMN lastName
        SET NOT NULL,
    ALTER COLUMN email SET NOT NULL,
    ALTER COLUMN birthDate SET NOT NULL;