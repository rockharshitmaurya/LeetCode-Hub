# Write your MySQL query statement below
SELECT p.product_id,ifnull(ROUND(SUM(us.units*p.price)/SUM(us.units),2),0) as average_price FROM
prices p LEFT JOIN unitssold us ON p.product_id=us.product_id
and us.purchase_date BETWEEN p.start_date AND p.end_date GROUP BY 1;