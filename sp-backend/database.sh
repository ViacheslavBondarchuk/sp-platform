PGPASSWORD=postgres psql -U postgres <<EOF
  drop database sp;
  create database sp owner postgres;
  \q
EOF

PGPASSWORD=postgres psql -U postgres -d sp <<EOF

create table if not exists users(
    id bigserial not null unique,
    username varchar(25) not null unique,
    password varchar(255) not null,
    first_name varchar(25)not null,
    last_name varchar(25) not null,
    phone varchar(15) not null,
    primary key(id)
);

EOF
