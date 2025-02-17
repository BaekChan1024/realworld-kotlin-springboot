create table if not exists user
(
    id       BIGINT primary key auto_increment,
    username varchar(100) not null unique,
    bio      varchar(1024),
    image    varchar(1024),
    email    varchar(255) not null,
    password varchar(255) not null
);

create table if not exists article
(
    id          BIGINT primary key auto_increment,
    slug        varchar(255) not null,
    title       varchar(255) not null,
    description text not null,
    created_at  TIMESTAMP    not null default current_timestamp,
    updated_at  TIMESTAMP    not null default current_timestamp,
);

create table if not exists article_user
(
    id      BIGINT primary key auto_increment,

)