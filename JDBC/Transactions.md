# Transactions

* a unit of work.
* All work complete or failed.
* powerful but must be managed
* breaks down in distributed systems quickly

## Commit
* tells system that transaction is done.
* can be commmited to disk
* interim state is held in swap till this point

## Rollback
* Returns the data to the state it was prior to transaction starting
* if no locking and transaction completed, data not lost only current transaction.
* All uncommitted data is purged.
* often failure scenario but not required.

## Auto-Commit
* Default for many dbs
* not transactional
* Data is immediately committed.
* no concept of atomic transactions.
* not recommended for most.
* often either a driver or transactional setting on connection.

