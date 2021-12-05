# Memory Management

* Stack
  
  Every thread has its own stack managed by jvm.
  Java knows when data on the stack can be destroyed.

  All local variables are created onto stack and popped when closing curly bracket of enclosing block is reached.

* Heap

  Used to store data that has longer life than single function or block.
  
  All memory of application except stack.
  One heap is shared across all threads.
  Objects placed on heap
  For objects a pointer is stored on stack.

### Example

List<String> myList = new ArrayList<>();

myList.add("One");

The new keyword finds free space on heap and will reference from local variable called __myList__

__"One"__ is also created on heap.
referenced from within the list.
nothing is created in the stack. Not reachable from code directly.

