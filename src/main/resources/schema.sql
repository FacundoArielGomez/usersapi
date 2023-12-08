create table if not exists USERS (
    id bigint auto_increment,
    name varchar(255),
    age int,
    CREATED_DATE DATE,
    CREATED_AT TIMESTAMP,
    email varchar(255),
    PRIMARY KEY (id)
);