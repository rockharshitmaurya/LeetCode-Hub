# Write your MySQL query statement below
# 11/203
# SELECT query_name,ROUND(AVG(rating/position),2) quality
# AVG(CASE WHEN rating < 3 THEN 1 ELSE 0 END) poor_query_percentage
# from Queries GROUP BY 1;

SELECT query_name, ROUND(AVG(rating / position), 2) AS quality,
  ROUND(SUM(IF(rating < 3,1,0))/count(rating)*100,2) AS poor_query_percentage
FROM Queries
GROUP BY query_name;
