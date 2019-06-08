drop table if exists mg_blog_article;

create table mg_blog_article (
  id serial not null,
  title text,
  content text,
  author integer,
  last_updated timestamp,
  primary key (id)
);
