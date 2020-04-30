CREATE TABLE user_status
(
    code VARCHAR(255)
);

INSERT INTO user_status (code)
VALUES ('ACTIVE'),
       ('LOCKED');

ALTER TABLE users
    ADD COLUMN password VARCHAR(255),
    ADD COLUMN status VARCHAR(255) default ('ACTIVE');

