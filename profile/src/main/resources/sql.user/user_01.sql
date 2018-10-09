drop table if exists mg_user_role;
drop table if exists mg_role;
drop table if exists mg_user;

create table mg_role(
  id integer,
  name varchar(200),
  primary key(id)
);

create table mg_user(
  id integer,
  username varchar(200) unique not null,
  password varchar(400) not null,
  firstname varchar(200),
  lastname varchar(200),
  email varchar(200),
  enabled tinyint(1),
  primary key(id)
);

create table mg_user_role(
  user_id integer,
  role_id integer,
  primary key(user_id,role_id),
  constraint foreign key (user_id) references mg_user (id),
  constraint foreign key (role_id) references mg_role (id)
);