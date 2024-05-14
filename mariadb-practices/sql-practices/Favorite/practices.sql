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

--
-- 날짜 함수
--

-- curdate(), current_date
SELECT CURDATE(), CURRENT_DATE FROM dual;

-- curtime(), current_time
SELECT CURTIME(), CURRENT_TIME FROM dual;

-- now() vs sysdate()
SELECT NOW(), SYSDATE() FROM dual;
SELECT NOW(), SLEEP(2), NOW() FROM dual;
SELECT SYSDATE(), SLEEP(2), SYSDATE() FROM dual;

-- data_format
-- default format: %Y년%m월%d일 %h시%i분%s초
SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %h:%i:%s') FROM dual;
SELECT DATE_FORMAT(NOW(), '%d %b %y %h:%i:%s') FROM dual;

-- period_diff
-- 근무 개월
-- 포맷팅: YYMM, YYYYMM
SELECT first_name, hire_date, PERIOD_DIFF(date_format(CURDATE(), '%y%m'), date_format(hire_date, '%y%m')) FROM employees;

-- date_add(=adddate), data_sub(=subdate)
-- 날짜를 date 타입의 칼럼이나 값에 type(year, month, day)의 표현식으로 더하거나 뺄 수 있다. 
-- 각 사원의 근속 연수가 5년이 되는 날에 휴가를 보내준다면 각 사원의 5년 근속 휴가 날짜는?
SELECT first_name, hire_date, DATE_ADD(hire_date, INTERVAL 5 year) FROM employees;

-- cast: varchar로 된 날짜를 date형으로 캐스팅 
SELECT '12345' + 10, CAST('12345' AS INT) + 10 FROM dual;
SELECT DATE_FORMAT(CAST('2013-01-09' AS DATE), '%Y년 %m월 %d일') FROM employees;
SELECT CAST(CAST(1-2 AS unsigned) as signed) FROM dual;
SELECT CAST(CAST(1-2 AS unsigned) as int) FROM dual;
SELECT CAST(CAST(1-2 AS unsigned) as integer) FROM dual;

-- type
-- 문제: varchar(200), char, text, CLOB(Character Large OBject)
-- 정수: medium int, int(signed, integer), unsigned, big int
-- 실수: float, double,
-- 시간: data, datetime
-- LOB: CLOB, BLOB(Binary Large OBject)

-- 1. 집계쿼리: select 절에 통계함수(count, max, min, sum, avg, variance, stddev ...)
SELECT AVG(salary), SUM(salary) FROM salaries;

-- 2. select 절에 그룹함수(집계함수)가 있는 경우, 어떤 칼럼도 select 절에 올 수 없다. 예외 : group by 에 있는 칼럼은 select 절에 존재할 수 있음
--    emp_no는 아무 의미가 없다.
SELECT emp_no, AVG(salary) FROM salaries;

-- 3. query 순서
-- 3.1. from: 접근 테이블 확인
-- 3.2. where: 조건에 맞는 row를 선택 (임시 테이블)
-- 3.3. 집계(결과 테이블)
-- 3.4. projection
-- 사번이 10060인 사원이 받은 평균 월급
SELECT AVG(salary) AS '평균 월급'  FROM salaries WHERE emp_no=10060;

-- 4. group by에 참여하고 있는 칼럼은 projection이 가능하다. : select 절에 올 수 있다. 
-- 사원 별 평균 월급
SELECT emp_no, AVG(salary) FROM salaries GROUP BY emp_no;

-- 5. having: 집계결과(결과 테이블)에서 row를 선택해야 하는 경우
-- 이미 where 절은 실행이 되었기 때문에 having 절에 이 조건을 주어야 한다.
-- 평균월급이 60000 달러 이상인 사원의 사번과 평균월급을 출력
SELECT emp_no, AVG(salary) FROM salaries GROUP BY emp_no HAVING AVG(salary)>=60000;

-- 6. order by: 항상 맨 마지막 출력(projection)전에 한다. 
SELECT emp_no, AVG(salary) AS avg_salary FROM salaries GROUP BY emp_no HAVING AVG(salary)>=60000 ORDER BY avg_salary ASC;

-- 주의: 사번이 10060인 사원의 사번, 평균 월급, 급여 총합을 출력
-- 문법적으로 오류, 의미적으로 맞다.
SELECT emp_no, AVG(salary), SUM(salary) FROM salaries WHERE emp_no=10060;

-- 문법적으로 옳다.
SELECT emp_no, AVG(salary), SUM(salary) FROM salaries GROUP BY emp_no HAVING emp_no=10060;

--
-- inner join
--

-- 현재, 근무하고 있는 직원의 이름과 직책을 모두 출력
SELECT
	employees.first_name, titles.title
FROM
	employees,
	titles
WHERE
	employees.emp_no = titles.emp_no 	-- join 조건(n-1)
	AND titles.to_date = '9999-01-01'; 	-- row 선택 조건
	
-- 현재, 근무하고 있는 직원의 이름과 직책을 모두 출력하되, 여성 에니지어만 출력
SELECT
	employees.first_name,
	titles.title
FROM
	employees,
	titles
WHERE
	employees.emp_no = titles.emp_no 	-- join 조건(n-1)
	AND titles.to_date = '9999-01-01' 	-- row 선택 조건1
	AND employees.gender = 'F' 			-- row 선택 조건2
	AND titles.title = 'Engineer'; 		-- row 선택 조건3
	
--
-- ANSI/ISO SQL1999 Join 표준문법
--

-- 현재, 직원별 근무 부서를 출력
-- 사번, first name, 부서명 순으로 출력
SELECT employees.emp_no, employees.first_name, departments.dept_name FROM employees, departments, dept_emp WHERE employees.emp_no = dept_emp.emp_no and departments.dept_no = dept_emp.dept_no and to_date='9999-01-01';

-- 현재, 지급되고 있는 급여를 출력
-- 사번, 이름, 급여 순으로 출력
SELECT employees.emp_no, employees.first_name, salaries.salary FROM employees, salaries WHERE employees.emp_no = salaries.emp_no AND salaries.to_date LIKE '9999%';

-- Natural Join
-- 조인 대상이 되는 두 테이블에 이름이 같은 공통 칼럼이 있는 경우
SELECT employees.first_name,titles.title FROM employees NATURAL JOIN titles WHERE titles.to_date LIKE '9999%';

-- join ~ using
-- natural join 문제점 : 같은 칼럼 여러 개가 모두 조인됨
SELECT count(*) FROM salaries as a natural join titles as b where a.to_date LIKE '9999%' and b.to_date LIKE '9999%';
SELECT count(*) FROM salaries as a join titles as b using(emp_no) where a.to_date LIKE '9999%' and b.to_date LIKE '9999%';

-- join ~ on
-- 현재, 직책별 평균 연봉을 큰 순서대로 출력
SELECT a.title, AVG(b.salary) FROM titles a JOIN salaries b on a.emp_no = b.emp_no WHERE a.to_date LIKE '9999%' and b.to_date LIKE '9999%' GROUP BY a.title ORDER BY AVG(b.salary) DESC;

-- 현재, 직책별 평균연봉과 직원수를 구하되 직원수가 100명 이상인 직책만 출력
-- 직책, 평균연봉, 직원수
SELECT a.title, AVG(b.salary), COUNT(*) FROM titles a JOIN salaries b ON a.emp_no = b.emp_no WHERE a.to_date LIKE '9999%' and b.to_date LIKE '9999%' GROUP BY a.title HAVING COUNT(*) >= 100;

-- 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 연봉을 출력
-- 부서이름, 평균급여

SELECT
	a.dept_name,
	AVG(d.salary)
FROM
	departments a,
	dept_emp b,
	titles c,
	salaries d
WHERE
	a.dept_no = b.dept_no
	AND b.emp_no = c.emp_no
	AND c.emp_no = d.emp_no
	AND b.to_date LIKE '9999%'
	AND c.to_date LIKE '9999%'
	AND d.to_date LIKE '9999%'
	AND c.title = 'Engineer'
GROUP BY
	a.dept_name
ORDER BY
	AVG(d.salary)
	DESC; 

--
-- outer join
--

-- insert into dept values(null, '기획');
-- insert into dept values(null, '총무');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '개발');

SELECT * FROM dept;

INSERT INTO emp VALUES(null, '둘리', 1);
INSERT INTO emp VALUES(null, '마이콜', 1);
INSERT INTO emp VALUES(null, '또치', 1);
INSERT INTO emp VALUES(null, '길동', null);

-- inner join
SELECT a.name, b.name FROM emp a join dept b on a.dept_no = b.no;

-- left (outer) join
SELECT a.name as '이름', IFNULL(b.name, '없음') as '부서' FROM emp a left join dept b on a.dept_no = b.no;

-- left (outer) join
SELECT ifnull(a.name, '없음') as '이름', b.name as '부서' FROM emp a right join dept b on a.dept_no = b.no;

-- full (outer) join
-- mariadb 지원 안함









