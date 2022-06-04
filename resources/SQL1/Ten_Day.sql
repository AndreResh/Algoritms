# 182. Duplicate Emails
select email
from Person
group by email
having count(*) > 1;

#---------------------------------------------------------------------
# 1050. Actors and Directors Who Cooperated At Least Three Times
select actor_id, director_id
from actorDirector
group by actor_id, director_id
having count(*) >= 3;

#---------------------------------------------------------------------
# 1587. Bank Account Summary II
select u.name, SUM(t.amount) as balance
from Users u join Transactions t on u.account = t.account
group by t.account
having SUM(t.amount) > 10000;

#---------------------------------------------------------------------
# 1084. Sales Analysis III
select distinct p.product_id, p.product_name
from Product p join Sales s on p.product_id = s.product_id
where not p.product_id = any(select product_id from Sales  where sale_date < '2019-01-01' or sale_date > '2019-03-31')
order by p.product_id;

