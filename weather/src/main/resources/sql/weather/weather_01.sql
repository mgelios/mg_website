drop table if exists mg_current_weather;
drop table if exists mg_weather_forecast;

create table mg_current_weather (
  id integer not null auto_increment,
  time timestamp not null,
  city_name varchar(200) not null,
  longitude double not null,
  latitude double not null,
  main_info varchar(200) not null,
  description varchar(400) not null,
  icon varchar(200) not null,
  temperature double not null,
  pressure double not null,
  humidity double not null,
  min_temp double not null,
  max_temp double not null,
  visibility double not null,
  wind_speed double not null,
  wind_degree double not null,
  sunrise timestamp not null,
  sunset timestamp not null,
  uvi double not null,
  primary key(id)
);

create table mg_weather_forecast (
  id integer not null auto_increment,
  time timestamp not null,
  temperature double not null,
  min_temp double not null,
  max_temp double not null,
  pressure double not null,
  sea_level double not null,
  ground_level double not null,
  humidity double not null,
  main_info varchar(200) not null,
  description varchar(400) not null,
  icon varchar(200) not null,
  wind_speed double not null,
  wind_degree double not null,
  primary key(id)
);