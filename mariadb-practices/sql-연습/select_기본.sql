--
-- select
--

-- 예제1: departments 테이블의 모든 데이터 출력
SELECT * FROM departments;

-- 프로젝션(projection)
-- 예제2: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
SELECT first_name, gender, hire_date FROM employees;

-- as(alias, 생략가능)
-- 예제3: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
SELECT
	first_name as '이름',
	gender as '성별',
	hire_date as '입사일'
FROM
	employees;

-- distinct
-- 예제 4. titles 테이블에서 모든 직급의 이름을 출력
SELECT distinct title from titles;
SELECT concat('hello', ' ', 'world') as '이름', gender, hire_date FROM employees;

