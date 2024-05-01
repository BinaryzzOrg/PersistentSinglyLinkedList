![PersistentLinked_List](https://github.com/BinaryzzOrg/PersistentSinglyLinkedList/assets/54339540/7a93df1f-8029-489c-a79b-079f3356f7fc)

## Persistent Data Structure - a data structure that always preserves the previous version of itself when it is modified.

# Instructions
###### Program Requirements:
Your task is to create a persistent singly linked list that will implement the following operations:

1. Append: Adds a new node at the end of the list. The time complexity of this operation must be O(1).

2. Delete: Deletes a node at the position specified by the user. This operation implements tombstoning
which refers to the process of marking elements or nodes within the data structure as deleted without
actually removing them. When an element is deleted, it is marked as "tombstoned" or "deleted" in the data
structure, indicating that it should be considered absent in subsequent versions.

3. Change Value: Modifies the value of the node at the position specified by the user. Implement fat node
to have a record of modification history.

4. Display: Traverses the list and displays the current value of each node.

5. Node History: Displays the current value and the previous value(s) of a node at the position specified by
the user.

6. List History: Traverses the list and displays the current value of each node (including the tombstoned
nodes).
Note: Each node in the list has a value (an integer variable) and a pointer to the next node.

###### Sample Output:
wla pa
