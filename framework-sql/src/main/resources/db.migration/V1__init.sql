create table if not exists user
(
    id       BIGINT primary key auto_increment,
    username varchar(100) not null unique,
    bio      varchar(1024),
    image    varchar(1024),
    email    varchar(255) not null,
    password varchar(255) not null
);