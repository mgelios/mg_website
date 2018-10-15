drop table if exists mg_current_weather;
drop table if exists mg_weather_forecast;


create table mg_current_weather {
  id integer,
  primary key(id)
}

create table mg_weather_forecast {
  id integer,
  primary key(id)
}