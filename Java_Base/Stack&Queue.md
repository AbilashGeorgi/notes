# Stack

ordered list of objects following LIFO.

insert done using push()

delete by pop()

> java.util.Stack
> peek() - view the top element
> size()

pop() on stack that is empty will cause error
so check stack.isEmpty()

* Stacks are useful when you need to reverse something or keep track of state.

# Queue

ordered list, insertion at end, removal at begining.

java.util.Queue - interface.

choose implementation
* Linked List - standard queue implementation
* Priority Queue

enqueue using add()

>peek()
>remove()
>traverse using while(queue.isEmpty()) queue.remove();

* good for storing order in which somthing happened or needs to happen.

