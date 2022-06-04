# 1141. User Activity for the Past 30 Days I
select activity_date  as day, count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-28'
group by  activity_date;


# ------------------------
# 1693. Daily Leads and Partners
select date_id, make_name, count(distinct lead_id) as unique_leads, count(distinct partner_id) as unique_partners
from DailySales
group by date_id, make_name;

# ------------------------
# 1729. Find Followers Count
select user_id, count(*) as followers_count
from Followers
group by user_id
order by user_id;