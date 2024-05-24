select version(), CURRENT_DATE, now() from dual;

-- 수학함수, 사칙연산도 된다.
select sin(pi()/4), 1 + 2 * 3 - 4 / 5 from dual;

-- 대소문자 구분이 없다.
sELect VERSION(), CURRENT_DATE, NOW() from dual;

-- table 생성: DDL
create table pet(
	name varchar(100),
	owner varchar(50),
	species varchar(20),
	gender char(1),
	birth DATE,
	death DATE
);

-- schema 확인
DESCRIBE pet;
DESC pet;

-- table 삭제
drop table pet;
drop table untitled_table_1;
show tables;

-- insert: DML(C)
insert into pet VALUES('콩자반', '천민서', 'cat', 'f', '1999-01-30', NULL);

-- select: DML(R)
SELECT * FROM pet;

-- update: DML(U)
update pet set name='콩콩자반' WHERE NAME='콩자반';
SELECT * FROM pet;

-- delete: DML(D)
DELETE FROM pet WHERE NAME='콩자반';

-- load data
LOAD DATA LOCAL infile '/root/pet.txt' INTO TABLE pet;

-- select 연습
SELECT NAME, species FROM pet WHERE NAME='콩자반';

SELECT NAME, species, birth FROM pet WHERE birth >= '1990-2-4';

SELECT NAME, species FROM pet WHERE gender='f' AND species='cat';

SELECT NAME, birth FROM pet ORDER BY birth asc;

SELECT NAME, birth FROM pet ORDER BY birth desc;

SELECT NAME, birth FROM pet WHERE death is not null;

SELECT NAME, birth FROM pet WHERE death is null;

SELECT NAME FROM pet WHERE NAME LIKE '%fy';

SELECT NAME FROM pet WHERE NAME LIKE '%p%';

SELECT COUNT(*) from pet;

DROP TABLE cart;

DROP TABLE book;

drop table category;
drop table orders_book;
drop table user;