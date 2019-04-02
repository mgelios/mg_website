drop table if exists mg_currency_statistics;
drop table if exists mg_currency_conversion;
drop table if exists mg_currency;
drop table if exists mg_crypto_currency;

create table mg_currency (
  id serial not null,
  system_id integer not null,
  date timestamp not null,
  abbreviation varchar(25) not null,
  scale real not null,
  name varchar(100) not null,
  rate real not null,
  primary key (id)
);

create table mg_currency_conversion (
  id serial not null,
  currency_from integer references mg_currency(id) not null,
  currency_to integer references mg_currency(id) null,
  value real not null,
  primary key (id),
  constraint unique_conversion unique (currency_to, currency_from)
);

create table mg_currency_statistics (
  id serial not null,
  date timestamp not null,
  currency integer references mg_currency(id) null,
  rate real not null,
  primary key (id)
);

create table mg_crypto_currency(
  id integer not null
);

