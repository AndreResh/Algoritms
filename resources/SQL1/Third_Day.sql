# Fix Names in a Table
# select user_id,  CONCAT((UPPER(substring(name, 1,1))), LOWER(SUBSTRING(name,2,LENGTH(name)))) as name
# from Users
# order by user_id;

# ---------------------------------------------------------
# Patients With a Condition
select patient_id, patient_name, conditions
from Patients
where conditions like "DIAB1%" or conditions like "% DIAB1%";

# ---------------------------------------------------------
# Group Sold Products By The Date
select   sell_date, count(DISTINCT product) as num_sold, GROUP_CONCAT(DISTINCT product) as products
from Activities
group by  sell_date
order by sell_date asc;