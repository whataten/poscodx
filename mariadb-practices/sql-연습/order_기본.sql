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
