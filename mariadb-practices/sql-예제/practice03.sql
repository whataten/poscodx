-- 문제 1.
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.

SELECT
	e.emp_no,
	e.first_name,
	s.salary
FROM
	employees e
	JOIN salaries s ON e.emp_no = s.emp_no
WHERE 
	s.to_date LIKE '9999%'
ORDER BY
	s.salary DESC;

-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.

SELECT
	e.emp_no, e.first_name, t.title
FROM
	employees e
	JOIN titles t ON e.emp_no = t.emp_no
WHERE
	t.to_date LIKE '9999%'
ORDER BY 
	e.first_name;

-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요.

SELECT
	e.emp_no, e.first_name, t.title
FROM
	employees e
	JOIN titles t ON e.emp_no = t.emp_no
WHERE
	t.to_date LIKE '9999%'
ORDER BY 
	t.title;

-- 문제4.
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

SELECT
	e.emp_no, e.first_name, s.salary, t.title, d.dept_name
FROM
	employees e,
	salaries s,
	titles t,
	departments d,
	dept_emp de
WHERE
	e.emp_no = s.emp_no AND
	s.emp_no = t.emp_no AND
	t.emp_no = de.emp_no AND
	d.dept_no = de.dept_no
ORDER BY
	e.first_name;

-- 문제5.
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력 합니다.

SELECT
	*
FROM
	employees e,
	titles t
WHERE
	e.emp_no = t.emp_no
	AND t.to_date != '9999-01-01'
	AND t.title = 'Technique Leader';

-- 문제6.
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.

SELECT
	e.last_name,
	d.dept_name,
	t.title
FROM
	employees e,
	dept_emp de,
	titles t,
	departments d
WHERE
	e.emp_no = de.emp_no
	AND de.emp_no = t.emp_no
	AND d.dept_no = de.dept_no
	AND e.last_name LIKE 'S%';

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.

SELECT
	concat(e.first_name, ' ', e.last_name)
FROM
	titles t,
	salaries s,
	employees e
WHERE
	t.emp_no = s.emp_no
	AND s.emp_no = e.emp_no
	AND t.to_date LIKE '9999%'
	AND s.salary >= 40000
ORDER BY
	s.salary DESC;

-- 문제8.
-- 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오

SELECT
	t.title,
	s.salary
FROM
	titles t,
	salaries s
WHERE
	t.emp_no = s.emp_no
	AND s.salary >= 50000
	AND t.to_date LIKE '9999%'
ORDER BY
	s.salary DESC;

-- 문제9.
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.

SELECT DISTINCT
	d.dept_name
FROM
	departments d,
	dept_emp de,
	salaries s
WHERE
	d.dept_no = de.dept_no
	AND de.emp_no = s.emp_no
	AND s.to_date LIKE '9999%'
ORDER BY
	s.salary DESC;

-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.

SELECT DISTINCT
	t.title
FROM
	titles t,
	salaries s
WHERE
	t.emp_no = s.emp_no
	AND s.to_date LIKE '9999%'
ORDER BY
	s.salary DESC;
