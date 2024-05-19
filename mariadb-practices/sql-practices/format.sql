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
	s.salary DESC


-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.