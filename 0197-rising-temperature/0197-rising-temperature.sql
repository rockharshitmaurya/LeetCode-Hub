# Write your MySQL query statement below
SELECT w1.id FROM weather w1 INNER JOIN weather w2
where DATEDIFF(w1.recordDate,w2.recordDate)=1 AND w1.temperature>w2.temperature;
# WHERE w1.Temperature > w2.Temperature AND DATEDIFF(w1.recordDate , w2.recordDate) = 1

# select DATEDIFF(w1.recordDate,w2.recordDate) Diff from weather w1 INNER JOIN weather w2 ON w1.id=w2.id;