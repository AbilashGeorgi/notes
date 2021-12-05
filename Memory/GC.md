# Garbage Collection

Stack is very efficient and easily managable. but its scope is tight.

Sharing objects between code blocks need heap.

Option not provided to choose storage in java as it was one of the design laws.

the vm makes the most efficient choice for us.


>String one = "hello";

>String two = "hello";

java vm reuses object for one for two. This is called __Internalising__ of strings.

vm puts them into a pool and reuses. Generally only happens on little strings and not on strings that are calculated from something else.

to internalise string(not usually used): 
> string.intern();

## Garbage Eligibility

When we finish using obj in java we don't have to specify.

Objects that are not freed continue to consume memory still system restart. This is called a _memory leak_.

Java avoids this by:

* Running on a virtual machine.
The vm is just another program written in c.
Controls request of memory and freeing of memory.

* Garbage Collection. Invented in LISP. 
Automatic process analyses objects that are not needed.

Any object on the heap that is not referenced from the stack is eligible from gc.__Unreachable__ objects. (ex: nested or circular references in heap)



Program should have no dealings with gc.
There are some methods.
>gc() method of System class suggests run of gc.
but no gurantee.

gc temporarily stops all threads. Therefore application is temporarily suspended.


When an obj is actually gced, java runs the finalize() method in Object.


### leaks?
soft leaks. somehow referenced on stack eventhough it is not used.

*****

-Xmx10m -> max heap size to 10 megabytes


*****
JVisualM
******

Rather than searching for objects that need to be removed, gc searches for objects that need to be retained and rescues them.

The algorithm that gc use is called __Mark and Sweep__. 

In marking stage, program execution is paused. Called __stop the world__ event.

Checks every single live reference.

After, a full scan of heap takes place and those not marked are freed up.

Objects that are kept are moved to a single contigous block of memory to prevent fragmentation.

Faster the more garbage there is.

If there are lots of objects not garbage, users may notice freeze. 

To avoid this there is __Generational Garbage Collection__. 
* Most objs don't live long.
* If it lives through one gc, it is likely to survive forever.

GGC is a way of organising the heap.
heap divided into 2:
* Young Generation. -> typically smaller but can be tuned. New objects created here. wil fill up quickly. When full gc occurs in young generation. should be quick as most temporary objects. Surviving are copied to old
generation. This gc is called __minor gc__.
* Old Generation: gc run only if needed. called __major gc__. could take few seconds.

Eden, S0, S1. (survivor space). are splits in Younger generation.

Old generation (after 8 gc).

https://stackoverflow.com/questions/13312229/where-did-jvisualvm-go



In java 6 after old gen, there is a **perm gen**. Survives forever never gced.

Internalised strings and meta data from class.

For server applications, each time you redeploy, a new data is created for permgen while previous run is still there.
So tomcat etc should be restarted.

From java 7, internalised strings are not in perm gen.

From java 8, no perm gen, instead **metaspace** stores metadata. 

Not part of heap and allocated from system native memory.

When class are no longer creatable, meta data is removed.

So metadata is removed in redeploying.


