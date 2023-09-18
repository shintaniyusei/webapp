show databases;
use cae;
show tables;
CREATE TABLE comment
(
  id int unsigned not null auto_increment primary key,
  name varchar(100),
  atime varchar(150),
  btime varchar(50),
  com varchar(150),
  `date` timestamp
);

ALTER TABLE comment ADD COLUMN elapsed_time DECIMAL(5, 2);
UPDATE comment
SET elapsed_time = TIME_TO_SEC(TIMEDIFF(atime, btime)) / 3600;
    
describe comment;
show tables;
select * from comment;

CREATE TABLE employee
(
  ID VARCHAR(10),
  name VARCHAR(20),
  money INTEGER(20)
  );
INSERT INTO employee(ID, name, money) VALUES('1000', 'a', 950);
INSERT INTO employee(ID, name, money) VALUES('1001', 'b', 900);
INSERT INTO employee(ID, name, money) VALUES('1002', 'c', 890);

select * from employee;

CREATE TABLE caluclation AS
SELECT
    comment.name,
    comment.atime,
    ROUND(TIME_TO_SEC(TIMEDIFF(comment.btime, comment.atime)) / 3600,1) AS elapsed_time
FROM comment;

ALTER TABLE caluclation ADD COLUMN caluclate INT;

UPDATE caluclation
SET caluclate = money * elapsed_time;

CREATE TRIGGER trigger_comment
AFTER INSERT ON comment
FOR EACH ROW
BEGIN
    INSERT INTO caluclation (name, atime, elapsed_time)
    VALUES (NEW.name, NEW.atime, ROUND(TIME_TO_SEC(TIMEDIFF(NEW.btime, NEW.atime)) / 3600, 1));
END;


DELETE FROM caluclation
WHERE name IN('数学', '国語', '英語', 'アルゴリズム');


select * from caluclation
DROP TRIGGER IF EXISTS insert_into_caluclation;
drop table caluclation