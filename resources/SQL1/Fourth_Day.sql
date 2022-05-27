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

#------------------------------------------------
# 1795. Rearrange Products Table
select product_id, 'store1' as store, store1 as price
from Products where store1 is not null
union
select product_id,'store2' as store, store2 as price
from Products where store2 is not null
union
select product_id,'store3' as store,store3 as price
from Products where store3 is not null


#------------------------------------------------
# 608. Tree Node
select id, case
               when p_id is null then 'Root'
               when id = any(select distinct p_id from Tree where p_id is not null) then 'Inner'
               else 'Leaf'
    end as type
from Tree;