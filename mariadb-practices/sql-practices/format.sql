-- 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 연봉을 출력
-- 부서이름, 평균급여 
SELECT a.dept_name, AVG(d.salary) FROM departments a, dept_emp b, titles c, salaries d WHERE a.dept_no = b.dept_no AND b.emp_no = c.emp_no AND c.emp_no = d.emp_no AND b.to_date LIKE '9999%' AND c.to_date LIKE '9999%' AND d.to_date LIKE '9999%' and c.title = 'Engineer' GROUP BY a.dept_name ORDER BY AVG(d.salary) DESC;