drop table if exists mg_user;

create table mg_user(
  id serial,
  username varchar(200) unique not null,
  password varchar(400) not null,
  firstname varchar(200),
  lastname varchar(200),
  email varchar(200),
  enabled boolean,
  primary key(id)
);
