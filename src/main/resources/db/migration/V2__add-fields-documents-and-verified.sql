CREATE TABLE document
(
    id            VARCHAR(255)
        CONSTRAINT document_pk PRIMARY KEY,
    path          VARCHAR(255)
        CONSTRAINT document_path_notnull NOT NULL
        CONSTRAINT document_path_unique UNIQUE,
    time_received TIMESTAMP
        CONSTRAINT document_time_received_notnull NOT NULL,
    time_finished TIMESTAMP
);

CREATE TABLE field_status
(
    code VARCHAR(255)
        CONSTRAINT field_status_pk PRIMARY KEY
);

INSERT INTO field_status
    (code)
VALUES ('VERIFIED'),
       ('SUPERUSER_VERIFICATION_REQUIRED'),
       ('USER_VERIFICATION_REQUIRED');

CREATE TABLE field
(
    id          VARCHAR(255)
        CONSTRAINT field_pk PRIMARY KEY,
    document_id VARCHAR(255)
        CONSTRAINT field_document_id_notnull NOT NULL
        CONSTRAINT field_document_id_fk REFERENCES document (id),
    value       VARCHAR(999),
    status      VARCHAR(255)
        CONSTRAINT field_status_notnull NOT NULL
        CONSTRAINT field_status_fk REFERENCES field_status (code)
);

CREATE TABLE verified
(
    id            VARCHAR(255)
        CONSTRAINT verified_pk PRIMARY KEY,
    field_id      VARCHAR(255)
        CONSTRAINT verified_field_id_notnull NOT NULL
        CONSTRAINT verified_field_id_fk REFERENCES field (id),
    value         VARCHAR(999),
    verified_by   VARCHAR(255)
        CONSTRAINT verified_user_id_fk REFERENCES users (id),
    time_received TIMESTAMP
        CONSTRAINT verified_time_received_notnull NOT NULL,
    time_finished TIMESTAMP
);
