# Calculate Special Bonus
select employee_id, case
                        when employee_id % 2 != 0 and name not like 'M%' then salary
                        else 0
    end
    as bonus
from Employees

order by employee_id;

# SELECT employee_id,
#        IF(employee_id%2!=0 AND name NOT LIKE 'M%', salary,0)
#            AS bonus
# FROM Employees
# ORDER BY employee_id ASC;
# ---------------------------------------------------------
# Swap Salary

UPDATE Salary
SET sex = (
CASE sex
WHEN "f" THEN "m"
ELSE "f" END )

