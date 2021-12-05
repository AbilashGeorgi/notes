# JDBC (Java Database Connectivity)

API for client-side accesss to a database.

Specifically RDBMS focused.

SPEC: JSR 221 - JDBC 4

* Allows you to have universal data access.
* Hot Swappable
* Standard SQL
* JDBC drivers should be available.
* Can run same code against 2 different databases in theory.

### Basic Flow.

    Application mounts driver 

      Create connection.

        Execute SQL

          Commit/Rollback
          
            Close Connection.


### Exceptions

* All JDBC operations throw SQL Exception.

* Named exceptions - catch/throw.

* Standardized SQLSTATE code available to identify what went wrong.

* ErrorCode is available but vendor specific

## TERMINOLOGY

### Connections.
DriverManager - class that interacts with driver for creating connections.

for modern class that interacts with driver(used in actual applications/ multi-threaded systems)

Provides thread pooling etc.


Connection is a class that dev interacts with that manages actual communication b/w client and server.


### Executions

* Statement - representation of SQL to be executed against the database.(QUERY OR STATEMENT)

* ResultSet is the response in logical tabular form

* PreparedStatement - extension of statement, used for precompiled statements with inputs.

* CallableStatement - extension of PreparedStatement that references stored procedures in databases.

### Transactions

Block of code that executes together with a single commit.

* Auto-commit: a function of the database driver itself where each statement is immediately readable by all process once executed in the RDBMS
(commited immedieately)

* Transaction - series of statement that must be executed completely or not at all.

* Rollback - all statements in current transaction are removed such that it appears to have never occurred.