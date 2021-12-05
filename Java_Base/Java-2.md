# Java - 2

## Jigsaw

Before Java 9, a JAR was a unit of modularity and had explicit interfaces to interact with others, but weakly encapsulated its own elements.

__Project Jigsaw__ 
Introduced modularization in java.
provides configurations and containment.

JDK was modularised.

we can install specific modules that we need

customized JDK for various platforms.

improved performance

encapsulate internal APIs

Using modul definition files, devs can modularize their own applications.

## Optionals

provide solution to represent values that may or may not exist.

An Optional is a container object which may or may not have a given value

> isPresent() - does value exist

> get() - retrive value

> Optional.empty() / Optional.of("")

> opt.orElse("default");

## Lambdas

allows you to pass functions as data

before java 8 all functions had to belong to a class.

on the fly function.

A consumer lambda doesn't return anything
> Consumer<String> printItem = n ->  System.out.println(s)
> students.forEach(printItem);

Function accepts and returns value
> Function <Integer, Integer> doubly = n -> n * 2;
> doubly.apply(8);

Predicate - returns true/false
> IntPredicate isDivByThree = n -> n%3==0;
> isDivByThree.test(3)

Supplier - no input only output

> Supplier<Double> randNumUnder100 = () -> Math.random() * 100;
> randNumUnder100.get();

## Streams

more concise iteration.

stream is a sequence of items.

> Stream.of("","","")
> Arrays.stream(array)
> list.stream

for each element do something
> .forEach()

parallel
> .parallelStream() 

any item meets condition
> .anyMatch(predicate)

filter
> .filter(predicate)

map
> .map()

## Local Variable Type Inference

helps collapse long class names

initialize without having to specify associated type

we can use: 

var list = List.of("abc", "abc");
var total = 38.23;

still statically typed.

from java 10 for local variables, indexes and enhanced for loops etc.

still debatable.

## Switch

switch(stage) {
  case 0:
    season = "Spring";
    break;
  case 1:
    season = "Summer";
    break
  default:
    season = "INvalid";
}

season = switch(stage) {
  case 0, 2 -> "Spring";
  case 1 -> "Summer";
  default -> {
    System.out.println("this is invalid");
    yield "Invalid stage";
  }
};

default is __required__
break is implied





