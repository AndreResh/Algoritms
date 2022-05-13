-- Customers Who Never Order

select c.name as Customers
from Customers c left join Orders o on c.id = o.customerId
where o.customerId is null;

-- select customers.name as 'Customers'
-- from customers
-- where customers.id not in
--       (
--           select customerid from orders
--       );
---------------------------------------------------------
-- Big Countries

-- select name, population, area
-- from World
-- where area >= 3000000 or population >= 25000000;

SELECT
    name, population, area
FROM
    world
WHERE
        area >= 3000000

UNION

SELECT
    name, population, area
FROM
    world
WHERE
        population >= 25000000
;
---------------------------------------------------------
-- Find Customer Referee

select name
from Customer
where referee_id is null or referee_id <> 2;
---------------------------------------------------------
-- Recyclable and Low Fat Products

select product_id
from Products
where low_fats = "Y" and recyclable = "Y"