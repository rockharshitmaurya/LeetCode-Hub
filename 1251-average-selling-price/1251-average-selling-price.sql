# Write your MySQL query statement below
SELECT us.product_id,ROUND(SUM(us.units*p.price)/SUM(us.units),2) as average_price FROM
prices p INNER JOIN unitssold us ON p.product_id=us.product_id
WHERE us.purchase_date BETWEEN p.start_date AND p.end_date GROUP BY 1;