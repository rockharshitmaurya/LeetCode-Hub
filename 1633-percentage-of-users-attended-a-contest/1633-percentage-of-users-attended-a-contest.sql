# Write your MySQL query statement below
# SELECT r.contest_id,ROUND(((count(r.user_id)/count(u.user_id))*100),2) percentage
# FROM USERS u LEFT JOIN Register r ON
# u.user_id=r.user_id WHERE u.user_id=r.user_id GROUP BY r.user_id ORDER BY percentage DESC,r.contest_id ASC;

# ROUND(((count(*)/(select count(user_id) from Users))*100),2) percentage
SELECT r.contest_id,ROUND(((count(*)/(select count(user_id) from Users))*100),2) percentage
FROM USERS u INNER JOIN Register r ON
u.user_id=r.user_id GROUP BY r.contest_id ORDER BY percentage DESC,r.contest_id ASC;


# {"headers": ["user_id", "contest_id", "percentage"], 
# "values": [[6, 209, 3],
#            [6, 208, 3],
#            [6, 210, 3],
#            [6, 215, 2],
#            [2, 207, 1]]}

# {"headers": ["contest_id", "percentage"], 
# "values": [[207, 2], 
#            [209, 3], 
#            [208, 3], 
#            [210, 3], 
#            [215, 2]]}