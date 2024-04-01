CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    SELECT DISTINCT Employee.salary from Employee ORDER BY salary DESC LIMIT 1 OFFSET (N - 1)
  );
END;
$$ LANGUAGE plpgsql;