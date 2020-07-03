create table if not exists users
(
    id                         bigserial    not null unique,
    username                   varchar(25)  not null unique,
    password                   varchar(255) not null,
    first_name                 varchar(25)  not null,
    last_name                  varchar(25)  not null,
    phone                      varchar(15)  not null,
    is_enabled                 boolean      not null,
    is_account_non_locked      boolean      not null,
    is_account_non_expired     boolean      not null,
    is_credentials_non_expired boolean      not null,
    primary key (id)
);

create table if not exists authorities
(
    id      bigserial   not null unique,
    user_id bigserial   not null,
    name    varchar(15) not null,
    primary key (id),
    foreign key (user_id) references users(id)
);
