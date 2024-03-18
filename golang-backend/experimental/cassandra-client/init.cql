docker exec /bin/sh

cqlsh




-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS my_keyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create a table
CREATE TABLE IF NOT EXISTS my_keyspace.my_table (
id text PRIMARY KEY,
name text,
age int
);
