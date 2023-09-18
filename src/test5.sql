show databases;
use cae;
show tables;
CREATE TABLE test
(
  id int unsigned not null auto_increment primary key,
  name varchar(100),
  attend varchar(100),
  leave varchar(100),
  'data' timestamp
);
describe test;
show tables;
select * from test;