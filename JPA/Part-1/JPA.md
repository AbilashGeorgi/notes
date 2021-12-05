# JPA

## Persistence

* information that continues to exist even after application that created it is no longer running.
* retrieve process transform analyze
* Storage - relational, nosql, file sys etc.

## JPA
* java obj and relational databases


## ORM
Object relational mapping
* OO language and relational databases.
* data organised using tables in rdb
* OOP uses objects and classes

### JAVA EE uses JPA
* jpa abstraction on top of JDBC
* lives in javax.persistence package
* jpa is specification and doesn't do anything own its own.
* needs instance provider.
  * eclipse link
  * hibernate etc.

* mapping b/w obj and tables is defined via persistence metadata.
  * annotations
  * xml - overwrites annotations


### ENTITY
 objects living in db and mapped to it.
> @Entity

* has unique id
@Table - name of table
@Id - primary key
@GeneratedValue - generation of id
@Column

#### Entity Manager API
* access to db
* performs crud

#### JPQL 
* layer on top of sql
* greater flexibility than entity.
* results are returned as collection of entities
* doesn't support nosql or json.


## JDBC 
low level api to interact with rdbms
* connection
* query
* update
* process query results


## LIFECYCLE

diff bw entity and java obj : entity managed by entity manager.
* managed - under control of em
* detached - final stage of lifecycle.

Steps: 
* java obj
* transient
* managed
* loaded from database
Any updates to entity using setters are automatically synced.
* removed - marked for removal
* detached - remove complete then gc.

## Java Transaction API 

@Transactional annotation

Group operations as a single unit.

can use EntityTransaction but JTA just uses @Transactional on class or method.

## Mapping Strategy

default - @Entity, public or prot no args constructor, not final class or mapped attr.

@Id - identifies unique id

entity -> table

id -> primary key

attributes -> columns

string -> varchar(255)
long -> bigint

@Transient - to not map


-------

## Relationships

Bi directional or uni directional

Cardinality - how many exist in each side of relationship

@ManyToOne
### @JoinColumn(name="sample")
Like foreign key relationship

tends to be better from a performance perspective.

### @JoinTable
Uses a 3rd table to associate relation.
2 foreign keys

reduces redundancy


-------
### Cardinality

### one to one
by default uses join column

### one to many
by default uses join table
### many to one
by default uses join column
### many to many
by default uses join table

----

### Cascading

by default no persist is cascaded.

use @OneToMany(cascade = CascadeType.PERSIST)
