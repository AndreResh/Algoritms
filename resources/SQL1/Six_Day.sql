
# 607. Sales Person
select distinct sp.name
from Orders o
         right join SalesPerson sp on o.sales_id = sp.sales_id
where o.com_id is null or not sp.sales_id = any(select sales_id from Orders o left join Company c on o.com_id = c.com_id
                                                where c.name = 'RED');
# -------------------------------------------------------------------------------
# 197. Rising Temperature
select w1.id from Weather w1 join Weather w2 on DATEDIFF( w1.recordDate, w2.recordDate )=1
where w2.temperature < w1.temperature;