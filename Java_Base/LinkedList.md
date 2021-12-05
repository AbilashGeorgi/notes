# Linked List

* linear data structure where elements containing data of the same type are linked using pointers.
* allows modification and retrieval in a sequential manner.

* each element is called a node. contains data and pointer to next element.
If the pointer is null, this should be the last node.

* first item is called the head
* last item is called the tail.

* items do not need to be stored next to each other. Insertion and deletion is less expensive

* Singly Linked List : nodes only point to next
* Doubly : nodes point to next and previous node.

### Advantages
* efficient at inserting and deleting, has dyanmic size
* unlike array, we don't shift elements for insertion or deletion
* queue and stack can be implemented using this

### Disadvantages
* more memory than array
* search or node traversal is still time consuming