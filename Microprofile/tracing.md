# Tracing

monolith - entry and exit traces

microservice - multiple applications

each request has a unique id called correlation id.

which is used in trace.

tracing can be a seperate service.

* agreed api for exchanging correlation id
* log in same format

OpenTracing - standard API with different implementations.

Provides a Tracer Interface

various languages supported

Microprofile - Open Tracing API provided.

Tracer classes need to be provided in our applications

Zipkin - A distributed tracing system.

includes timing for requests

Zipkin manages both collection and lookup of data

zipkin get started.

create docker network

> docker network create tracing
> docker run --rm --name zipkin --network tracing -p 9411:9411 openzipkin/zipkin

@Trace can be used to change default behaviour of tracing

tracing info can also be done for non jax-rs endpoints

# Connect 2 microprofile applications

microprofile-rest-client

> cp -R app1 app2

create 2 applications

configure rest client.

webapp -> META-INF -> microprofile-config.properties
com.example.demo.GreetingClient/mp-rest/url=http://demo:9080/demo

mvn install and docker build applications

create docker network

start app1

> docker run --rm --name demo --network <name> -p 9080:9080 <tag>

> docker run --rm --name demo2 --network <name> -p 9081:9080 <tag>

# Enable distributed tracing

run both applications
run zipkin

