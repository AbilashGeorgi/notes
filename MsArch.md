# Domain Based Decomposition.

* Data Domains
    * driven by data itself
    * underlying schema unimportant
    * focus on data patterns

Start with model not data store.

Evaluate actions.

Build the service/contracts first.

most common.

# Business Process Based.

help with structuring.

may have to recreate code logic multiple times.

can be used as higher level of service.

allows to encapsulate related domains.

No datasource access

Should have distinct functional uses.

* Identify process
* Identify domains
* Define API
* Wire service

# Atomic Transaction-based.

eventual consistency is not good enough

when span multiple data domain.

Guarantee ACID transactions across domains.

may need to provide failure domains and support for rollback

force blocking api call until commit

synchronous and blocking

* ensure need
* underlying domains must be in the shared database
* clear and concise rules
* consider fast failure

----------

# STRANGLER PATTERN

strangle dependencies off monolith.

can be top down.

or can be bottom up.

carving out

# SIDE CAR PATTERN

Side car deployed as module associated with applicable ms

removing repetitive code.

logging, monitoring, network services.

* determine process
* build sidecar
* schedule to deploy with other service.
* functionality appears without embedding it.



-------------
# Integration Patterns

## Gateway Patterns

API Gateway pattern is an ingress pattern for clients communicating.

Client ability to call any api can cause chaos

Gateway pattern provides buffer.

Facade/Proxy

Proxy, Mutate or limit calls.

Can become Single point of failure.

* Can mutate your requests. 
* security and authorization logic in a single ingress point
* decorate payloads
* can aggregate payloads
* limit access
* Movement buffer

#### Strategy
* Define contracts
* Expose APIs
* adhere to strict version control and passive changes only
* Implement gateway to call your services and your client calls gateway

## Process Aggregator Pattern

multiple data domains called together in a business process - business process

several business processes that must be called together and have a composite payload.

Aggregator provides clients single API to call

can introduce its own processing logic

can introduce a choke point. long blocking calls.

* determine business processes
* determine processing rules
* design a consolidated model
* design API for the actions on that model
* wire service and implement internal processing

## Edge Pattern

subset of gateway.

Client use varies by platform and scaling a gateway pattern presents wasted resources or clients need special business logic.

client specific "gateways"

focus on isolating calls for client systems

* identify client and needs
* build contracts
* implement contracts
* Maintain passivity as long as client is needed

## Gateway vs edge

Similiar but different 

Edge targets clients

Edge is more scalable

Edge is more flexible for new clients

Gateway has less moving parts


# DATABASE PATTERN

## Single Service Database Pattern

Scalability between service and db are related.

Each service implementation gets its own datastore.

Datastore distributes with the service.

Datastore scales proportionally to the service.

## Shared Service Database Pattern

All data domains exist within a single database

Data distribution should be handled by the database

Break data domains into schemas or similar constructs.

Users don't span schemas

Data domains connect to single schema

## Command Query Responsibility Segregation CQRS

Multi model bounded context

Multi-interface operations, write versus read

Divergence from simple CRUD

Dramatically increases complexity

* Task-based UI operations

* Eventual consistency is a must

* Event-based models

## Asynchrounous Eventing

complex workflows cannot fit in single blocking call
in real time

Service API to trigger event

cascades async from API

can trigger from messaging

powerful in distributed systems


--------
# Operational Patterns

how you run your system

## Log Aggregation

logs provide detailed info of microservice artifact

must be consistent across services.

must be structured.

must share a taxonomy

aggregation of various logs

parsing of logs

correlation of logs

indexing of logs

## Metrics Aggregation

need to know what is going on with the system

common taxonomy is critical

standard libraries are available as for logging

Metrics shipping.

Dashboard

-------------

Build high level dashboard
build detailed dashboards
inject events, especially deployments
trace alarms on your graphs
ensure runbooks on all alarms

## Tracing Patterns

Call stacks span processes, so code traces are less valuable

should span from the edge to the database

no call is lost

use standards based approaches

## Externalized Configuration

use consistent tooling

use consistent naming

err on the side of externalization

protect secrets

* Config is injected or retrieved

* application utilizes externalized values in favor of embedded

* Common libraries or tooling helps

* read, config and act

## Service Discovery

Central location of all services

Advertise what they offer

service can query central location to find what you need

consume the uri from discovery engine instead of config

