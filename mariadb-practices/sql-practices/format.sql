-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?

SELECT
	count(*)
FROM
	salaries
WHERE
	to_date LIKE '9999%'
	AND salary >= (
		SELECT
			avg(salary)
		FROM
			salaries
		WHERE
			to_date LIKE '9999%');
-- 문제2.
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.

SELECT
	e.emp_no,
	concat(e.first_name, ' ', e.last_name) AS name,
	d.dept_name,
	s.salary
FROM
	employees e,
	dept_emp de,
	salaries s,
	departments d
WHERE
	e.emp_no = s.emp_no
	AND e.emp_no = de.emp_no
	AND d.dept_no = de.dept_no
	and(de.dept_no, s.salary)
	in(
		SELECT
			de.dept_no, max(s.salary)
			FROM salaries s, dept_emp de
		WHERE
			s.emp_no = de.emp_no
			AND s.to_date LIKE '9999%'
			AND de.to_date LIKE '9999%'
		GROUP BY
			de.dept_no)
ORDER BY
	s.salary DESC;
-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요

SELECT
	e.emp_no,
	concat(e.first_name, ' ', e.last_name) AS name,
	s.salary
FROM
	dept_emp de,
	employees e,
	salaries s,
	(
		SELECT
			de.dept_no,
			avg(s.salary) AS avg_salary
		FROM
			dept_emp de,
			salaries s
		WHERE
			de.emp_no = s.emp_no
			AND de.to_date LIKE '9999%'
			AND s.to_date LIKE '9999%'
		GROUP BY
			de.dept_no) ds
WHERE
	e.emp_no = s.emp_no
	AND e.emp_no = de.emp_no
	AND de.dept_no = ds.dept_no
	AND de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
	AND ds.avg_salary < s.salary;
-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

SELECT
	e.emp_no,
	concat(e.first_name, ' ', e.last_name),
	m.manager,
	d.dept_name
FROM
	dept_emp de,
	employees e,
	departments d,
	(
		SELECT
			dm.dept_no,
			concat(e.first_name, ' ', e.last_name) AS manager
		FROM
			dept_manager dm,
			employees e
		WHERE
			dm.emp_no = e.emp_no
			AND dm.to_date LIKE '9999%') m
WHERE
	e.emp_no = de.emp_no
	AND d.dept_no = de.dept_no
	AND m.dept_no = de.dept_no
	AND de.to_date LIKE '9999%';
-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.

SELECT
	e.emp_no,
	concat(e.first_name, ' ', e.last_name) AS name,
	t.title,
	s.salary
FROM
	dept_emp de,
	employees e,
	titles t,
	salaries s
WHERE
	de.emp_no = e.emp_no
	AND t.emp_no = e.emp_no
	AND e.emp_no = s.emp_no
	AND de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
	AND de.dept_no = (
		SELECT
			de.dept_no
		FROM
			dept_emp de,
			salaries s
		WHERE
			de.emp_no = s.emp_no
			AND de.to_date LIKE '9999%'
			AND s.to_date LIKE '9999%'
		GROUP BY
			de.dept_no
		ORDER BY
			avg(s.salary)
			DESC
		LIMIT 1)
ORDER BY
	s.salary ASC;
-- 문제6.
-- 평균 연봉이 가장 높은 부서는?

SELECT
	d.dept_name,
	round(avg(s.salary))
FROM
	salaries s,
	dept_emp de,
	departments d
WHERE
	s.emp_no = de.emp_no
	AND de.dept_no = d.dept_no
	AND s.to_date LIKE '9999%'
GROUP BY
	de.dept_no
ORDER BY
	round(avg(s.salary))
	DESC
LIMIT 1;-- 문제7.
-- 평균 연봉이 가장 높은 직책?

SELECT
	t.title,
	round(avg(s.salary))
FROM
	salaries s,
	titles t
WHERE
	s.emp_no = t.emp_no
	AND t.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
GROUP BY
	t.title
ORDER BY
	avg(s.salary)
	DESC
LIMIT 1;
-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

SELECT
	d.dept_name,
	concat(e.first_name, ' ', e.last_name) AS name,
	s.salary,
	m.manager,
	m.salary AS manager_salary
FROM
	departments d,
	employees e,
	salaries s,
	dept_emp de,
	(
		SELECT
			dm.dept_no,
			concat(e.first_name, ' ', e.last_name) AS manager,
			s.salary
		FROM
			dept_manager dm,
			employees e,
			salaries s
		WHERE
			dm.emp_no = e.emp_no
			AND e.emp_no = s.emp_no
			AND dm.to_date LIKE '9999%'
			AND s.to_date LIKE '9999%') m
WHERE
	d.dept_no = de.dept_no
	AND e.emp_no = de.emp_no
	AND e.emp_no = s.emp_no
	AND d.dept_no = m.dept_no
	AND de.to_date LIKE '9999%'
	AND s.to_date LIKE '9999%'
	AND s.salary > m.salary;