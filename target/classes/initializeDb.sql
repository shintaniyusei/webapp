-- -----------------------------------------
-- Initialize Table / テーブルの初期化 --
-- in this case, id is no meaning but convinient for some tools
-- この場合idは意味がありませんが、ツールによっては利便性があるため
-- -----------------------------------------

show databases;
use cae;
show tables;
-- drop table comment; -- if you want delete table 'comment'.
CREATE TABLE comment
(
  id int unsigned not null auto_increment primary key,
  sender varchar(100),
  content varchar(150),
  remoteIp varchar(50),
  `date` timestamp
);
describe comment;

insert into comment (sender, content, remoteIp, `date`) values ('Taro', 'Hello!', '133.95.0.1', '2022-07-06 12:00');
select * from comment;
-- show variables like 'char%'; -- check character code

-- describe comment;
-- Field    Type             Null Key Default             Extra
-- -------- ---------------- ---- --- ------------------- -----------------------------
-- id       int(10) unsigned NO   PRI NULL                auto_increment
-- sender   varchar(100)     YES      NULL                
-- content  varchar(150)     YES      NULL                
-- remoteIp varchar(50)      YES      NULL                
-- date     timestamp        NO       current_timestamp() on update current_timestamp()
-- 
-- select * from comment;
--   id sender content remoteIp   date
-- -- ------ ------- ---------- ---------------------
--  1 Taro   Hello!  133.95.0.1 2022-07-06 12:00:00.0
--
-- reference of timestamp
-- http://en.wikibooks.org/wiki/Structured_Query_Language/Data_Types#Temporal
-- http://www.techscore.com/tech/sql/SQL2/02_04.html/