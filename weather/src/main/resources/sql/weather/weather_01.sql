drop table if exists mg_current_weather;
drop table if exists mg_weather_forecast;

create table mg_current_weather (
  id serial not null,
  time timestamp not null,
  city_name varchar(200) not null,
  longitude real not null,
  latitude real not null,
  main_info varchar(200) not null,
  description varchar(400) not null,
  icon varchar(200) not null,
  temperature real not null,
  pressure real not null,
  humidity real not null,
  min_temp real not null,
  max_temp real not null,
  visibility real not null,
  wind_speed real not null,
  wind_degree real not null,
  sunrise timestamp not null,
  sunset timestamp not null,
  uvi real not null,
  primary key(id)
);

create table mg_weather_forecast (
  id serial not null,
  time timestamp not null,
  temperature real not null,
  min_temp real not null,
  max_temp real not null,
  pressure real not null,
  sea_level real not null,
  ground_level real not null,
  humidity real not null,
  main_info varchar(200) not null,
  description varchar(400) not null,
  icon varchar(200) not null,
  wind_speed real not null,
  wind_degree real not null,
  city_name varchar(200) not null,
  update_time timestamp not null,
  primary key(id)
);