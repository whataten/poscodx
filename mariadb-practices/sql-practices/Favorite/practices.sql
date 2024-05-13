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

--
-- where
--

-- 예제1: employees 테이블에서 1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
SELECT
	CONCAT(first_name, ' ', last_name) AS '이름',
	gender AS '성별',
	hire_date AS '입사일'
FROM
	employees
WHERE
	hire_date < '1999-01-01';

-- 논리 연산자
-- 예제2: employees 테이블에서 1989년 이전에 입사한 여직원의 이름

SELECT
	CONCAT(first_name, ' ', last_name) AS '이름',
	gender AS '성별',
	hire_date AS '입사일'
FROM
	employees
WHERE
	hire_date < '1989-01-01'
	AND gender = 'F';

-- in 연산자
-- 예제3: dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서 번호 출력

SELECT
	emp_no,
	dept_no
FROM
	dept_emp
WHERE
	dept_no = 'd005'
	OR dept_no = 'd009';

SELECT
	emp_no,
	dept_no
FROM
	dept_emp
WHERE
	dept_no in('d005', 'd009');

-- like 검색
-- 예제4: employees 테이블에서 1989년에 입사한 직원의 이름, 입사일을 출력
SELECT
	first_name,
	hire_date
FROM
	employees
WHERE
	hire_date >= '1989-01-01'
	AND hire_date <= '1989-12-31';

SELECT
	first_name,
	hire_date
FROM
	employees
WHERE
	hire_date BETWEEN '1989-01-01'
	AND '1989-12-31';

SELECT
	first_name,
	hire_date
FROM
	employees
WHERE
	hire_date LIKE '1989-%';

--
-- ORDER BY
--

-- 예제1: employees 테이블에서 직원의 전체이름, 성별, 입사일을 입사일 순으로 출력
SELECT
	CONCAT(first_name, ' ', last_name) AS '이름',
	gender AS '성별',
	hire_date AS '입사일'
FROM
	employees
ORDER BY hire_date ASC;

-- 예제2: salaries 테이블에서 2001년의 월급을 가장 높은 순으로 사번, 월급을 출력
SELECT
	emp_no,
	salary
FROM
	salaries
WHERE
	from_date LIKE '2001%'
	OR to_date LIKE '2001%'
ORDER BY
	salary DESC;

-- 예제3: 남자직원의 이름, 성별, 입사일을 입사일순(선임순)으로 출력
SELECT
	first_name,
	gender,
	hire_date
FROM
	employees
WHERE
	gender = 'M'
ORDER BY
	hire_date ASC;

-- 예제3: 직원의 사번, 월급을 사번(asc), 월급(desc)으로 출력
SELECT emp_no, salary FROM salaries ORDER BY emp_no ASC, salary DESC;


--
-- 수학함수
--

-- abs
SELECT ABS(1), ABS(-1) FROM dual;

-- ceil
SELECT CEIL(3.14), CEILING(3.14) FROM dual;

-- FLOOR
SELECT FLOOR(3.14) FROM dual;

-- mod
SELECT MOD(10, 3), 10 % 3 FROM dual;

-- round(x) : x에 가장 근접한 정수
SELECT ROUND(1.498), ROUND(1.511) FROM dual;

-- round(x, d) : x값 중에 소수점 d 자리에 가장 근접한 실수
SELECT ROUND(1.498, 1) FROM dual;

-- power(x, y) : pow(x, y) : x의 y제곱
SELECT POWER(2, 10), POW(2, 10) FROM dual;

-- sign(x)
SELECT SIGN(20), SIGN(0) FROM dual;

-- greatest(x, y, ...), least(x, y, ...) 
SELECT GREATEST(10, 20, 30, 40), LEAST(10, 20, 30, 40) FROM dual;
SELECT GREATEST('b', 'A', 'C', 'D') FROM dual;

--
-- 문자열 함수
--

-- upper
SELECT UPPER('seoul'), UCASE('seoul') FROM dual;
SELECT UPPER(first_name) FROM employees;

-- lower
SELECT LOWER('SEOUL'), LCASE('SEOUL') FROM dual;
SELECT LOWER(first_name) FROM employees;

-- substring(문자열, index, length)
SELECT SUBSTRING('hello world', 3, 2);

-- 예제: 1989년에 입사한 직원들의 이름, 입사일을 출력
SELECT first_name, SUBSTRING(hire_date, 9, 2) FROM employees WHERE hire_date LIKE '1989%';

-- lpad(오른쪽 정렬, 왼쪽 채움), rpad(왼쪽 정렬, 오른쪽 채움)
SELECT LPAD('1234', 10, ' '), RPAD('1234', 10, ' ') FROM dual;

-- 예제) 직원들의 월급을 오른쪽 정렬 (빈공간은 *)
SELECT LPAD(salary, 10, '*') FROM salaries;

-- trim, ltrim, rtrim 
SELECT concat('---', LTRIM('   hello   '), '---') FROM dual;
SELECT concat('---', RTRIM('   hello   '), '---') FROM dual;
SELECT concat('---', TRIM(LEADING 'x' FROM 'xxxhelloxxx'), '---') FROM dual;
SELECT concat('---', TRIM(TRAILING 'x' FROM 'xxxhelloxxx'), '---') FROM dual;
SELECT concat('---', TRIM(BOTH 'x' FROM 'xxxhelloxxx'), '---') FROM dual;

-- length
SELECT LENGTH('hello world') FROM dual;


















