select customer_number
from Orders
group by customer_number
order by count(*) desc limit 1;

# -------------------------------------------------
# 1741. Find Total Time Spent by Each Employee
select event_day as day, emp_id, SUM(out_time)-SUM(in_time) as total_time
from Employees
group by event_day, emp_id


# -------------------------------------------------
# 1890. The Latest Login in 2020
select user_id, MAX(time_stamp) as last_stamp
from Logins
where YEAR(time_stamp) = 2020
group by user_id;

# -------------------------------------------------
# 511. Game Play Analysis I
select player_id, MIN(event_date) as first_login
from Activity
group by player_id;
