# Java

## JVM

java designed to make apps run on any machine with java without rewriting or __recompiling__

java code *(.java)* is compiled into java byte code _(.class)_.

JVM runs this byte code. It can run same byte code on any machine.

JVM has to be run on a given platform according to JVM specification.

platform-independent by abstraction.

contains specification, implementation, runtime instance.

it calls main method.

## JRE and JDK

__Java Runtime Environment__ and __Java Development Kit__ allow you to create and run Java Programs.

JRE contains the JVM as well as browser plug-ins for executing Java applets, core classes and supporting files.
(util libs like Collections, regex, logging; base libs like beans, Math etc; integration libraries like JDBC; User Interface Toolkit like Swing, Deployment tech like Java Web Start and Java Plug-in)

JDK is a full featured SDK for java and includes JRE as well as compilers(javac), archiver(jar), interpreter(java), debuggers and tools to create programs.

IDEs on top of JDK with code completion, user interface etc.

Integrated Development Environment.

## Classes, Instances, Constructors.

classes - blueprints for the objects we want to create in code.

class Dog:
  * attributes/fields:
    * breed - String
    * age - int 
    * color - color
  * behaviour:
    * bark - method/function

several different dogs can be created using a constructor.

instance is each object.

## Static Methods

* CLASS method
* do not need instance
* belongs to class itself
* can only access static class variables

dice example

## Scope

Parameters are how we pass information to a method in Java.

each input to a method is a parameter living only inside the method

instance variables available to instance

## Access Modifiers

determines how certain methods and variables can be accessed.

* private : only in class it lives in
* protected : visible to package and sub classes
* public : everywhere within the program
* no modifier : only within the package and __not__ sub classes.


