INSERT INTO users
(id, username, role)
VALUES ('6f7eae38-dfd2-4024-9ae2-e035e42d1adm', 'admin', 'ADMIN'),
       ('1e260359-d38c-44f3-bf9f-6fac8ad012u1', 'user1', 'USER'),
       ('db58cdfd-7374-4152-bf47-e48d4a95ceu2', 'user2', 'USER'),
       ('ca58711c-82ce-423a-8a44-3e00cea62bu3', 'user3', 'USER'),
       ('1e260359-d38c-44f3-bf9f-6fac8ad012u4', 'user4', 'USER'),
       ('db58cdfd-7374-4152-bf47-e48d4a95ceu5', 'user5', 'USER'),
       ('ca58711c-82ce-423a-8a44-3e00cea62bu6', 'user6', 'USER'),
       ('1e260359-d38c-44f3-bf9f-6fac8ad012u7', 'user7', 'USER'),
       ('db58cdfd-7374-4152-bf47-e48d4a95ceu8', 'user8', 'USER'),
       ('ca58711c-82ce-423a-8a44-3e00cea62bu9', 'user9', 'USER');

INSERT INTO document
(id, path, time_received)
VALUES ('6eddcd00-0322-42fa-a314-115141439bd1', 'D://Path1/1',
        TO_TIMESTAMP('2020-01-11 11:00:00 0000', 'YYYY-MM-DD HH24:MI:SS MS')),
       ('4ed650f3-36bf-4d11-a120-02856effe9d2', 'D://Path2/2',
        TO_TIMESTAMP('2020-01-11 11:00:05 0000', 'YYYY-MM-DD HH24:MI:SS MS')),
       ('9d09a5a7-1da0-4233-8bc9-7b8d3a5ca1d3', 'D://Path3/3',
        TO_TIMESTAMP('2020-01-11 11:00:10 0000', 'YYYY-MM-DD HH24:MI:SS MS'));

INSERT INTO field
(id, document_id, value, status, verifiers_amount)
VALUES ('836eb3f6-6892-4fe9-aa13-bf79b8c844f1', '6eddcd00-0322-42fa-a314-115141439bd1', 'd1f1', 'VERIFIED', 5),
       ('ebc08c51-ad3d-4aec-a87c-86b2a01929f2', '6eddcd00-0322-42fa-a314-115141439bd1', 'd1f2',
        'USER_VERIFICATION_REQUIRED', 1),
       ('73c5c722-300d-4496-a794-02f5b0ba69f3', '6eddcd00-0322-42fa-a314-115141439bd1', 'd1f3',
        'USER_VERIFICATION_REQUIRED', 4),
       ('52176d75-eafc-4704-b870-b8a9c809d7f4', '4ed650f3-36bf-4d11-a120-02856effe9d2', 'd2f1', 'VERIFIED',2),
       ('3cb74b9e-0614-4177-bc3d-a7516ca792f5', '4ed650f3-36bf-4d11-a120-02856effe9d2', 'd2f2',
        'USER_VERIFICATION_REQUIRED', 2),
       ('50fc6e80-0608-4fe9-ab52-f3b6b7019cf6', '4ed650f3-36bf-4d11-a120-02856effe9d2', 'd2f3',
        'USER_VERIFICATION_REQUIRED', 3),
       ('d248fea8-9f7f-4566-a258-7a4898e340f7', '9d09a5a7-1da0-4233-8bc9-7b8d3a5ca1d3', 'd3f1', 'VERIFIED', 0),
       ('ca76b31f-46d5-43e0-8e5e-0d61d25b46f8', '9d09a5a7-1da0-4233-8bc9-7b8d3a5ca1d3', 'd3f2',
        'USER_VERIFICATION_REQUIRED', 0),
       ('76ffa262-755f-402b-8075-88cf2fe7d2f9', '9d09a5a7-1da0-4233-8bc9-7b8d3a5ca1d3', 'd3f3',
        'USER_VERIFICATION_REQUIRED', 5);