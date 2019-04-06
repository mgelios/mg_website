drop table if exists mg_currency_statistics;
drop table if exists mg_currency_conversion;
drop table if exists mg_currency;
drop table if exists mg_crypto_currency;
drop table if exists mg_crypto_currency_market;

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
  id serial not null,
  name varchar(100) not null,
  symbol varchar(20) not null,
  rank integer not null,
  price_usd real not null,
  price_btc real not null,
  volume_usd_24h real not null,
  market_cap_usd real not null,
  available_supply real not null,
  total_supply real not null,
  max_supply real not null,
  percent_change_in_1h real not null,
  percent_change_in_24h real not null,
  percent_change_in_7d real not null,
  last_updated timestamp not null,
  primary key (id)
);

create table mg_crypto_currency_market(
  id serial not null,
  total_usd bigint not null,
  total_usd_day_volume bigint not null,
  active_markets integer not null,
  active_currencies integer not null,
  bitcoin_percent real not null,
  last_updated timestamp not null,
  primary key (id)
);
