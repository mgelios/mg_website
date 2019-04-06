drop table if exists mg_radiot_article;

create table mg_radiot_article(
  id serial not null,
  title text,
  content text,
  snippet text,
  main_picture text,
  link text,
  author text,
  original_time timestamp,
  radiot_time timestamp,
  feed text,
  slug text,
  comments bigint,
  likes bigint,
  last_updated timestamp,
  primary key (id)
);
