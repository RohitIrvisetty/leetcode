# Write your MySQL query statement below
select A.id from Weather A, Weather B where DATEDIFF(A.recordDate, B.recordDate) = 1 and A.temperature > B.temperature;