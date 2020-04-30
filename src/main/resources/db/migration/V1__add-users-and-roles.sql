CREATE TABLE users_role
(
    code VARCHAR(255)
        CONSTRAINT users_role_pk PRIMARY KEY
);

INSERT INTO users_role
VALUES ('ADMIN'),
       ('USER');

CREATE TABLE users
(
    id       VARCHAR(255)
        CONSTRAINT users_id_pk PRIMARY KEY,

    username VARCHAR(255)
        CONSTRAINT users_username_notnull NOT NULL,

    role     VARCHAR(255)
        CONSTRAINT users_role_code_notnull NOT NULL
        CONSTRAINT users_role_code_fk REFERENCES users_role (code)
);

