-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files

drop database if exists brewery;

create database brewery;

use brewery;

source beers.sql;

source breweries.sql;

source categories.sql;

source geocodes.sql;

source styles.sql;

-- Source SQL locally and in MySQL Workbench