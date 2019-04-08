drop table if exists mg_radiot_time_label_to_podcast;
drop table if exists mg_radiot_time_label;
drop table if exists mg_radiot_podcast;
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

create table mg_radiot_podcast(
  id serial not null,

  primary key (id)
);

create table mg_radiot_time_label(
  id serial not null,
  topic text,
  time timestamp,
  duration bigint,
  primary key (id)
);

create table mg_radiot_time_label_to_podcast(
  podcast_id integer not null,
  time_label_id integer not null,
  primary key (podcast_id, time_label_id)
);