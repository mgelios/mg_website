drop table if exists mg_blog_comment;
drop table if exists mg_blog_tag;
drop table if exists mg_blog_subcategory;
drop table if exists mg_blog_category;
drop table if exists mg_blog_article;

create table mg_blog_article (
  id serial not null,
  title text,
  content text,
  author integer,
  last_updated timestamp,
  primary key (id)
);

create table mg_blog_category (
  id serial not null,
  name text,
  primary key (id)
);

create table mg_blog_subcategory (
  id serial not null,
  name text,
  primary key (id)
);

create table mg_blog_tag (
  id serial not null,
  name text,
  primary key (id)
);

create table mg_blog_comment (
  id serial not null,
  text text,
  last_updated timestamp,
  article integer,
  primary key (id)
);