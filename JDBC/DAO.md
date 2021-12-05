# DAO Pattern

Data Access Objects.

Provides abstraction between JDBC and rest of code.

Can be simple abstraction or a true object.

Most use DTOs with DAOs/abstraction

Provides clear seperation of concerns.

## DTO

* Data Transfer Object

* Provides single-domain data

* Fully encapsulated objects that may contain sub objects.

* output and input of single DAO should be single DTO.

## DAO

* Usually leverages a common interface

* Concrete impl reaacts on a single-data domain.

* Can supprt multiple tables.

* Encapsulation of complex joins and aggreations

### DAO Factory

* Provides ability to leverage common paths for CRUD operations

* Loses value when you have custom methods.

* pure OOP.

## Repository pattern.

* Single table access per class
* DAO could be repo in case of Customer example.
* Instead of joining in db, you join in code.

### Distribution and Repositories

* Complex joins in the database require single-instance databases.
* Repo pattern allows sharding of database.
* You can store one piece of data in seperate db to facilitate distribution.
* horizontally scalable - repo
* highly normalized - dao pattern.
* atomic transactions that cross data tables can't use repo pattern.

