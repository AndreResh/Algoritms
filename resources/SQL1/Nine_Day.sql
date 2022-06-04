# 1393. Capital Gain/Loss
select stock_name, SUM(case
    operation
                           when operation = 'Sell' then price
                           else -1 * price
    end) as capital_gain_loss
from Stocks
group by stock_name;


# --------------------------------------------------------
# 1407. Top Travellers
select u.name, SUM(case  when r.distance is null then 0 else r.distance end) as travelled_distance
from Users u left join Rides r on u.id = r.user_id
group by r.user_id
order by  SUM(r.distance) desc, u.name asc

# --------------------------------------------------------
# 1158. Market Analysis I
select u.user_id as buyer_id, u.join_date, SUM(case when YEAR(o.order_date)= 2019 then 1
                                                    else 0 end) as orders_in_2019
from Users u left  join Orders o on o.buyer_id = u.user_id
group by u.user_id