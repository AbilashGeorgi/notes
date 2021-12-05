# DOCKER

# Container
a group of processes run in isolation.


Containers allow apps to run in isolation. prevents mem leak. also provide benefits for encapsulation.

Contains Application, OS, OS libraries, Application dependencies.

# Single Artifact

Allows dev to pass same artficat in Test Staging and Production

# Docker
containerization platform.

## Docker Engine

* Docker Daemon
  handles building running and administering containers

* REST API
  provides interfaces for other systems to talk to the daemon.

* CLI - most common way to interact.

--------------------

To create a docker container, we must first write a Dockerfile

It is a set of instructions to tell docker how to build your container

FROM - gives an existing container to create the first layer of the new container.

RUN - can be used to run os commands like mkdir

ADD - add artifacts like your application to the container

ends with : 

COMMAND/ ENTRY POINT - defines what the container will do when it starts up.

-------------

Docker containers are not build from scratch everytime

container image is build from dockerfile using: 
> docker build --help

images are stored in a private or public registry

dockerhub - a public registry

> docker run creates an instancs of the container

view containers : 
> docker ps -a [all]

build with tag: 
> docker build -t demo:0.0.1

run
> docker run -p [publish [hostport]:[containerport]] 9080:9080 demo:0.0.1

view images
> docker images

pull image
> docker pull [ubuntu]

> docker run -i -t ubuntu bash


> mvn install
> mvn liberty:run
> export MY_CUSTOM_ENV=SOMETHING