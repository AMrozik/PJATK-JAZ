alter table profile
    add column admin boolean;

UPDATE profile
SET admin = FALSE;

alter table profile
    alter column admin set not null;


-- admin account
-- password admin
insert into profile (username, password, firstname, lastname, email, birthdate, admin)
values ('admin', '$2y$10$SwN8Mf8HMps9L70J1vJGO.sKVPhNkvrCelFOpETnxYqUWSS9eR30i', 'root', 'root',
        'adminAlezon@gmail.com', '15/08/1998', TRUE);
