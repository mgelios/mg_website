# Datetime tips and tricks

## Offset problem solution

To solve problem of storage different datetime offsets in db
I have used next solution - use OffsetDateTime for both
DTO and Entity classes. Also for postgre db I have changed deafult
timestamp to TIMESTAMPTZ (type that stores timezone).

In that case backend becomes independent to instance timezone
and only timezone that matters is one on the client side.

## Mapping datetime

As I am using one approach to all datetimes in system
next optimization is pretty obvious.

In ``` utils ``` module I have created DateTimeMapper
and it can be used to support any kind of datetime mappings between
entities and DTOs. 