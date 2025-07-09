DELETE tb1
FROM Person as tb1, Person as tb2
WHERE tb1.Email = tb2.Email AND tb1.Id > tb2.Id;