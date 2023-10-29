# SQL Tutorial for Developers

## Introduction to SQL

SQL is a domain-specific language used for managing and querying relational databases. Here are some core concepts:

- **Database**: A structured collection of data.
- **Table**: A collection of related data organized into rows and columns.
- **SQL Statements**: Commands used to interact with databases.
- **Primary Key (PK)**: A unique identifier for each record in a table.
- **Foreign key (FK)** is a database constraint that ensures data integrity by linking a column in one table to the
  primary key of another table, enforcing referential integrity.
- **Index** is a database structure that improves the speed of data retrieval operations by providing a quick lookup
  of rows in a table based on the values of one or more columns

## Types of SQL Statements

### DDL (Data Definition Language):

DDL statements are used to define, modify, and manage the structure of database objects, such as tables, indexes, and
constraints. They focus on the creation, alteration, and deletion of database schema elements.

### DML (Data Manipulation Language):

DML statements are used to manipulate data within the database, including inserting, updating, and deleting records.

### DQL (Data Query Language)

DQL statements are used to retrieve and query data from a database, allowing users to extract specific information using
the SELECT statement and apply filtering and sorting to meet their data retrieval requirements.

### DCL (Data Control Language):

DCL statements are used to control access to data within the database and to manage user privileges.

## SQL execution order

The SQL execution order defines the sequence in which SQL statements are processed, determining how data is retrieved,
filtered, and manipulated to produce a final result set.

1. FROM
2. JOIN
3. WHERE
4. GROUP BY
5. HAVING
6. SELECT
7. DISTINCT
8. ORDER BY
9. LIMIT/OFFSET or FETCH/FIRST
10. UNION/INTERSECT/EXCEPT
11. Result Set

## Creating a Table

To create a new table, you can use the `CREATE TABLE` statement.

Below is an example of creating a "users" table with a few fields:

```sql
CREATE TABLE users
(
    user_id   INT PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    email     VARCHAR(100) UNIQUE,
    birthdate DATE,
    is_active BOOLEAN
);
```

## Creating an Index

To create an index on a table, you can use the `CREATE INDEX` statement. Here's an example of creating an index on the "
email" column of the "users" table:

```sql
CREATE INDEX idx_users_email ON users (email);
```

```sql
CREATE INDEX idx_product_sales
    ON sales (product_id, sales_date, customer_id);
```

## Dropping a Table

To delete a table and all its data, you can use the `DROP TABLE` statement. Be cautious, as this action is irreversible.
Here's an example of dropping the "users" table:

```sql
DROP TABLE users;
```

Running this command will permanently remove the "users" table and all of its data.

## Adding a Constraint

Adding foreign key:

```sql
ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customers
        FOREIGN KEY (customer_id)
            REFERENCES customers (customer_id);
```

Adding a unique constraint to a single column

```sql
ALTER TABLE employees
    ADD CONSTRAINT unique_email
        UNIQUE (email);
```

Adding a unique constraint to multiple columns

```sql
ALTER TABLE products
    ADD CONSTRAINT unique_product_code_and_vendor
        UNIQUE (product_code, vendor_id);
```

## Inserting Data

To add records to a table, use the `INSERT INTO` statement:

```sql
INSERT INTO table_name (column1, column2)
VALUES (value1, value2);
```

Example:

```sql
INSERT INTO employees (first_name, last_name)
VALUES ('John', 'Doe');
```

## Updating Data

To modify existing records, use the `UPDATE` statement:

```sql
UPDATE table_name
SET column1 = value1
WHERE condition;
```

Example:

```sql
UPDATE products
SET price = 49.99
WHERE product_id = 101;
```

## Deleting Data

To remove records, use the `DELETE` statement:

````sql
DELETE
FROM table_name
WHERE condition;
````

````sql
DELETE
FROM customers
WHERE customer_id = 5;
````

## Selecting Data

To retrieve data from a table, you can use the `SELECT` statement:

```sql
SELECT column1, column2
FROM table_name;
```

Example:

```sql
SELECT first_name, last_name
FROM employees;
```

## Selecting Data with distinct

```sql
SELECT DISTINCT last_name
FROM employees;
```

## Selecting Data with aliases

```sql
SELECT o.order_id, c.customer_name
FROM orders AS o
         JOIN customers AS c ON o.customer_id = c.customer_id;
```

## Filtering Data

You can filter data using the `WHERE` clause:

```sql
SELECT *
FROM table_name
WHERE condition;
```

Examples:

```sql
SELECT product_name, price
FROM products
WHERE category = 'Electronics';
```

```sql
SELECT product_name, price
FROM products
WHERE category = 'Electronics'
  AND price < 500
  AND in_stock = true;
```

```sql
SELECT customer_name, order_date
FROM orders
WHERE customer_id IN (101, 102, 105);
```

## Grouping and filtering data

The `GROUP BY` clause is used to group rows from a table based on the values in one or more columns, and the `HAVING`
clause is used to filter groups of rows based on aggregate conditions.

```sql
SELECT category, SUM(sales_amount) AS total_sales
FROM sales
GROUP BY category;
```

```sql
SELECT department, location, AVG(salary) as avg_salary
FROM employees
GROUP BY department, location;
```

```sql
SELECT category, SUM(sales_amount) AS total_sales
FROM sales
GROUP BY category
HAVING SUM(sales_amount) > 10000;
```

## Sorting Data

To order the results, use the `ORDER BY` clause:

```sql
SELECT *
FROM table_name
ORDER BY column_name;
```

Example:

```sql
SELECT customer_name, order_date
FROM orders
ORDER BY order_date DESC;
```

## Aggregating Data

Aggregate functions allow you to perform calculations on data:

- COUNT
- SUM
- AVG
- MAX
- MIN

Example:

```sql
SELECT AVG(salary)
FROM employees;
```

## Inner Join

- An inner join, also known as an equi-join, returns only the rows that have matching values in both tables being
  joined.
- It includes only the common data between the tables and omits non-matching rows.
- It is the most common type of join used in SQL for retrieving related data.

**Example of Inner Join:**

```sql
SELECT employees.first_name, departments.department_name
FROM employees
         INNER JOIN departments ON employees.department_id = departments.department_id;
```

(`INNER` keyword is optional, `JOIN` is always treated as `INNER JOIN`)

## Left Join (Left Outer Join)

- A left join returns all the rows from the left (first) table and the matching rows from the right (second) table.
  If there are no matches in the right table, it returns NULL values for the right table's columns.
- It ensures that all rows from the left table are included in the result, and only matching rows from the right table
  are
  added.
  Example of Left Join:

```sql
SELECT customers.customer_name, orders.order_date
FROM customers
         LEFT JOIN orders ON customers.customer_id = orders.customer_id;
```

## Right Join (Right Outer Join)

- A right join is the opposite of a left join. It returns all the rows from the right (second) table and the matching
  rows
  from the left (first) table. If there are no matches in the left table, it returns NULL values for the left table's
  columns.
- It ensures that all rows from the right table are included in the result, and only matching rows from the left table
  are
  added.

```sql
SELECT employees.first_name, departments.department_name
FROM employees
         RIGHT JOIN departments ON employees.department_id = departments.department_id;
```

## Full Join (Full Outer Join)

- A full join returns all rows when there is a match in either the left (first) table or the right (second) table. It
  includes matching rows and non-matching rows from both tables.
- It ensures that all rows from both tables are included in the result, and if there are no matches in one of the
  tables, it returns NULL values for the columns of the table with no match.

**Example of Full Join:**

```sql
SELECT customers.customer_name, orders.order_date
FROM customers
         FULL JOIN orders ON customers.customer_id = orders.customer_id;
```

## Using SELECT with UNION

```sql
SELECT employee_id, first_name, last_name
FROM employees
UNION
SELECT contractor_id, first_name, last_name
FROM contractors;
```

The `UNION` operator is used to combine the results of two or more SELECT statements into a single result set.

## Subqueries

Subqueries are queries nested inside other queries. They can be used in various SQL statements for more complex
operations:

```sql
SELECT column1
FROM table_name
WHERE column2 = (SELECT column2 FROM another_table);
```

Example:

```sql
SELECT product_name
FROM products
WHERE price > (SELECT AVG(price) FROM products);
```

## SQL fundamental knowledge for devs

List of core fundamental theoretical knowledge for software developers working with SQL

1. **Relational Database Concepts:**
    - Understanding of what a relational database is.
    - Knowledge of tables, rows, and columns.
    - Awareness of primary keys, foreign keys, and relationships between tables.
    - Comprehension of data normalization principles (1NF, 2NF, 3NF, etc.).

2. **SQL Language Fundamentals:**
    - Proficiency in SQL query syntax, including `SELECT`, `INSERT`, `UPDATE`, and `DELETE` statements.
    - Awareness of SQL data types (e.g., VARCHAR, INT, DATE, BOOLEAN).
    - Understanding of SQL operators, functions, and expressions.
    - Knowledge of SQL clauses such as `WHERE`, `ORDER BY`, `GROUP BY`, and `HAVING`.

3. **Data Retrieval:**
    - Ability to retrieve data from one or more tables using `SELECT` statements.
    - Skill in filtering data with the `WHERE` clause.
    - Mastery of sorting and aggregating data using `ORDER BY` and aggregate functions (e.g., `SUM`, `COUNT`, `AVG`).

4. **Data Modification:**
    - Competence in inserting new records using `INSERT INTO`.
    - Proficiency in updating existing data with `UPDATE` statements.
    - Skill in deleting records with the `DELETE` statement.
    - Knowledge of transactions and their management.

5. **Table Design:**
    - Familiarity with creating tables using the `CREATE TABLE` statement.
    - Understanding of primary keys, unique constraints, and foreign keys.
    - Knowledge of data types, constraints, and indexing.

6. **Indexes:**
    - Awareness of indexes and their role in optimizing query performance.
    - Understanding of how to create and manage indexes.

7. **Data Integrity:**
    - Knowledge of data integrity constraints, including `NOT NULL`, `UNIQUE`, and `CHECK` constraints.
    - Awareness of referential integrity and foreign key constraints.

8. **Normalization and Denormalization:**
    - Knowledge of the principles of data normalization.
    - Understanding when and how to denormalize data for performance optimization.

9. **Query Optimization:**
    - Awareness of query execution plans.
    - Proficiency in optimizing queries for performance using indexes, efficient joins, and subqueries.

10. **Security and Access Control:**
    - Understanding of SQL injection and best practices for preventing it.
    - Knowledge of user authentication and authorization.
    - Awareness of database roles and permissions.

11. **Transactions and Concurrency:**
    - Understanding of transactions, ACID properties (Atomicity, Consistency, Isolation, Durability), and their
      importance in multi-user environments.

12. **Backup and Recovery:**
    - Knowledge of database backup and recovery procedures.

13. **Database Systems:**
    - Familiarity with different database management systems (DBMS) like MySQL, PostgreSQL, Oracle, SQL Server, and
      their specific features.

14. **Data Modeling:**
    - Ability to create entity-relationship diagrams (ERD) for database design.

15. **NoSQL Databases:**
    - Understanding the differences between SQL and NoSQL databases and when to use each.

16. **Performance Tuning:**
    - Proficiency in identifying and addressing performance bottlenecks in SQL queries and database design.