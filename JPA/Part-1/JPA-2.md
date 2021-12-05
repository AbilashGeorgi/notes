
# JPA 2

## Inheritance

* Mapped superclass

  @MappedSuperclass
  produces tables for each child.

  base isnt an entity

  simplest approach

  Inheritance is only evident in class

  can't use polymorphic entities or relationships between child and base

* single table

  when base class needs to be managed

  super class is an entity

  all children mapped to same table

  it is default strategy

  @Inheritence(strategy = InheritanceType.SINGLE_TABLE)

  a discriminator column is added to the table
  (DTYPE). Column name can be changed using the @DiscriminatorColumn

  Polymorphic queries are efficient

  cannot use NOT NULL constraints as only subset of columns used.


* joined table

  each class is mapped to own database table

  subclasses don't used inherited fields

  subclasses contain primary key field with the same value as the matching record in the table of the parent class

  each query requires join which increases complexity

  NOT NULL can be used.


* table per class

  base and children seperate tables

  @Inheritence(strategy = InheritanceType.TABLE_PER_CLASS)

  Asoociations and polymorphic queries

  All subclass records are returned

  using UNION statement in background

  same columns in mulitple tables

  * easy and efficient
  * complexity
  * may become performance issue for more subclasses

----------------
# JPQL

defin queries for entities and their persistance state.

SQL like syntax

select objects or values

sql - rows and columns
jpql - entities

jpql uses mapping annotations to transform to sql

activate logging to check

-----

select <> from <> 
where <>
order by<>
group by<>
having<>

delete, update

functions - like avg
operators - like less than
numbers - sqrt size
strings - length, concat, dates


entityManager.createQuer(query).getResultList();


### createQuer()

create dynamic queries
instance of query to execute

### getResultList()

executes above query and returns list of entities

### setParameter()

binds parameter to query.

> where a.name = ?

> query.setParameter(0, ownerName);

dynamic queries:

* easy and straightforward
* cost of transforming to sql


## Named Queries

Statically defined

Predetermined unchangeable 

cannot be changed.

@NamedQuery annotation in entity class
@NamedQueries - multiple queries

> @NamedQuery(name = "Bug.findSeverBugs", query = "select t from Bug where t.name = 'abc'")

prefix query name with entity name.

> entityManager.createNamedQuery("Bug.findSevereBugs").getResultList();

named queries can also contain parameters.

* improve code organization
* more efficient because persistance provider can translate the query once application starts
* not customizable at runtime.

## Native Queries

jpql - small subset of sql standard
jpa supports native sql

jpa native sql return entities 

> select t.id, t.description, a.app_id from APPLICATIONS a, TICKET t 

> entityManager.createNativeQuery(jpql).getResultList();

named native queries are also possible.

* java code depends on underlying database and have to be adjusted for changes

## Stored Procedures

from JPA 2.1

2 ways

* dynamic
* declarative named

definde at entity

> @NamedStoredProcedureQuery(name = "findByRelease" procedurename = "FIND_TICKET_BY_RELEASE",
resultClasses = {Ticket.class},
parameters = {
  @StoredProcedureParameter( name = "p_id", type = Integer.class, mode = ParameterMode.IN)
})

* IN - input parameters
* OUT - output parameters
* INOUT - both
* REF_CURSOR - cursors for a result set

* complex sql stored in database

* code not directly tied to underlying db

## Stream API

JPA 2.2

getResultStream() - returns a java 8 stream of the result set.

Provide efficient way to move through a result set.

Scroll through the set instead of all results at once.

Defined statically or dynamically

reading large data sets cause entire data to be loaded before being used.

past implementations used paging but this is prone to errors from ongoing inserts and deletes

Cause inconsistencies while iterating

* overlap between stream api and database

* database maybe better at somethings better than java code 
  * filtering - where
  * sorting - order by



----------
# CRITERIA API

uses java language api instead of native sql

JPQL - Simple string, no compiler checking, queries break

CRITERIA - define queries for entities., written using java api, type-safe, portable, dynamic queries.

String based JPQL and JPA criteria-based queries are the same in performance and efficiency

## Create

> CriteriaBuilder cb = entityManager.getCriteriaBuilder();
 
> CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);

>Root<Ticket> ticket = cq.from(Ticket.class);

> cq.select(ticket);

> TypedQuer<Ticket> q = entityManager.createQuer(cq);

> List<Ticket> tickets = q.getResultList();

## Joins

created using join(attributeName, JoinType) of from interface

* JoinType.INNER
* JoinType.LEFT

inner is the default

> Join<Ticket, Release> releases = ticket.join("release");

can be cascaded.

## Where clause

where(boolean/Predicate)

each call causes previous where to be discarded.

# Persistence Provider

Persistence is a partnership between persistence provider and application.

provider supplies implementation engine for JPA
from EntitiyManager, QueryClasses to SQL generation

know supports from standard

are duplicates allowed?
support for laziness?
how is @DiscriminatorValue determined?


## Hibernate

default for spring boot

* extended support for natural IDs
* Loading multiple entities by their primary key
* management of creation and update timestamps
* Joining unassociated entities
* support for multi tenancy

## Eclipse Link

JPA's reference implementation

* handling of db changes
* composite persistence units to map entities to tables in multiple db
* multi tenancy

## OpenJPA

Opensource

design and runtime tools
* entity enhancement
* schema mapping
* metamodel class generation
* migration from other JPA providers





