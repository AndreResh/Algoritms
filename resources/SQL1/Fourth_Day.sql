# 1965. Employees With Missing Information
(select e1.employee_id
 from Employees e1
          left join Salaries s1 on e1.employee_id = s1.employee_id
 where s1.salary is null)
UNION
(select s2.employee_id
 from Employees e2
          right join Salaries s2 on e2.employee_id = s2.employee_id
 where e2.name is null)
order by employee_id;