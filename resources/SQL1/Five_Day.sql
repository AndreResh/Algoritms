# Article Views I
select DISTINCT author_id as id
from Views
where author_id =  viewer_id
order by author_id;
# ---------------------------------------------------------
# Customer Who Visited but Did Not Make Any Transactions
select v.customer_id, count(*) as count_no_trans
from Visits v
         left join Transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id;

# ---------------------------------------------------------
# Combine Two Tables
select p.firstName, p.lastName, a.city, a.state
from Person p
         left join Address a on p.personId=a.personId;

