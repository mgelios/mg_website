drop table if exists mg_user_role;
drop table if exists mg_role;
drop table if exists mg_user;

create table mg_role(
  id serial,
  name varchar(200),
  primary key(id)
);

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

create table mg_user_role(
  user_id integer references mg_user(id),
  role_id integer references mg_role(id),
  primary key(user_id,role_id)
);