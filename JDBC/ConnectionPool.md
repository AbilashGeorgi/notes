# Connection Pooling

* common data access pattern
* reuse connections from request to request
* works as a sort of cache of connections
* often managed by a pooling framework

### Why

* time saving mechanism
* lifecycle to create a connection is resource intensive
* costly operation as far as time goes
* cost of keeping connections open is cheaper than creating new ones.

### Typical Connection Creation routine

* Request from app to JVM
* JVM to OS for TCP socket
* Reach out to server and two way handshake, decide port
* os to jvm
* jvm to client

### Connection pooling.

* request from app to pool
* hand connection handle to application
* if none available in pool, still have full connection logic

#### Common libraries.

* apache commons DBCP
* C3PO
* HikariCP



