/*
*  CS211, Spring 2020
*  Jae Choi, Alex Larsen, Sean Michael, Vinh Nguyen
*  5/18/2020
*  Team Project 2
*  This abstract class contains methods which
*  work for both array lists and linked lists.
*/

import java.util.*;

public abstract class AbstractList<E> implements List<E> {
   
   public int size;        // current number of elements in the list

   // post: returns the current number of elements in the list
   public int size() {
      return size;
   }
   
    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        Iterator<E> itr = this.iterator();
        for (int i=0; i< index ; i++) {
            itr.next();
        }
        return (E) itr.next();
    }

   // post: creates a comma-separated, bracketed version of the list
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         Iterator itr = this.iterator();
         String result = "[" + itr.next();
         while(itr.hasNext()) {
            result+=", "+ itr.next();
         }
         result += "]";
         return result;
      }
   }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        Iterator itr = this.iterator();
        // ListNode<E> current = front.next;
        while (itr.hasNext()) {
            if (itr.next().equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }
        // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    public void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
   
   // post: returns true if list is empty, false otherwise
   public boolean isEmpty() {
      return size == 0;
   }

   // post: returns true if the given value is contained in the list,
   //       false otherwise
   public boolean contains(E value) {
      return indexOf(value) >= 0;
   }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

   // pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
   // post: inserts the given value at the given index, shifting subsequent
   //       values right
   // INCOMPLETE
   public abstract void add(int index, E value);

   // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
   // post: removes value at the given index, shifting subsequent values left
   // INCOMPLETE
   public void remove(int index) {
	   Iterator<E> itr = this.iterator();
	   while (itr.hasNext() && index >= 0) {
		   itr.next();
		   index--;
	   }
	   itr.remove();
   }

   // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
   // post: replaces the value at the given index with the given value
   // INCOMPLETE
   public abstract void set(int index, E value);
   
   // post: list is empty
   public void clear(){
	   Iterator<E> itr = this.iterator();
	   while (itr.hasNext()) {
		   itr.next();
		   itr.remove();
	   }
   }

   // post: appends all values in the given list to the end of this list
   public void addAll(List<E> other) {
      for (E value: other) {
         add(value);
      }
   }

   // post: returns an iterator for this list
   // INCOMPLETE
   public abstract Iterator<E> iterator();
   	  
}