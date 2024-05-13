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
