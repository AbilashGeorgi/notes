# CRUD

Create, Read, Update, Delete

Data Manipulation Language.

* Create
    
    Insert Statement

    Constraints must be honored.

    Isolation levles can impact results.

    Not an idempotent operations.

* Read Data

    SELECT 

    Constraints not important till join

    isolation levels can impact consistency

    Idempotent

    SELECT FOR UPDATE is a special case.

* UPDATE

    UPDATE

    Constraints can cause update anomalies

    Isolation levels impact

    Should be idempotent

* DELETE

    DELETE statement

    Constraints can cause errors and update anomalies

    Isolation levels can impact

    Idempotent after first execution

