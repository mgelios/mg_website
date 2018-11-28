drop table if exists mg_currency;
drop table if exists mg_currency_statistics;
drop table if exists mg_currency_conversion;
drop table if exists mg_crypto_currency;

create table mg_currency (
  id integer not null auto_increment,
  system_id integer not null,
  date timestamp not null,
  abbreviation varchar(25) not null,
  scale double not null,
  name varchar(100) not null,
  rate double not null,
  primary key (id)
);

create table mg_currency_conversion (
  id integer not null auto_increment,
  currency_from integer not null,
  currency_to integer not null,
  value double not null,
  primary key (id),
  constraint foreign key (currency_from) references mg_currency (id),
  constraint foreign key (currency_to) references mg_currency (id)
);

create table mg_currency_statistics (
  id integer not null auto_increment,
  date timestamp not null,
  currency integer not null,
  rate double not null,
  primary key (id),
  constraint foreign key (currency) references mg_currency (id)
);

create table mg_crypto_currency(
  id integer not null auto_increment;
);

