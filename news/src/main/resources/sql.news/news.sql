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
  url text,
  title text,
  date timestamp,
  image text,
  body text,
  show_notes text,
  audio_url text,
  primary key (id)
);

create table mg_radiot_time_label(
  id serial not null,
  topic text,
  time timestamp,
  duration bigint,
  podcast integer,
  primary key (id)
);
