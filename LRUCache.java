import java.util.HashMap;
import java.util.Map;
/*
 * This class generates an Least Recently Used cache using a hashmap and linked list data structures in order to get 
 * increased speed on accessing data as well as removing data
 * @author Riad El Mahmoudy
 */

class LRUCache {
	  // LRUHashtable backs up the Linked List for O(1) access to cache items
	  Map<Integer, ListNode> LRUhashtable = new HashMap<Integer, ListNode>(); //
	  ListNode head;
	  ListNode tail;

	  private int totalItemsInLRUCache;
	  private int max;

	  public LRUCache(int max) {
	    // cache starts empty and capacity is set by the user
	    totalItemsInLRUCache = 0; 
	    this.max = max;

	    // initiating head and tail nodes to avoid empty states
	    head = new ListNode();
	    tail = new ListNode();

	    // wire the head and tail together
	    head.next = tail;
	    tail.prev = head;
	  }
	  
      //getter method access the value with the key
	  public Integer get(int key) {
	    ListNode node = LRUhashtable.get(key); 

	    if (node == null) {
	      return null;
	    }

	    // the item has been accessed, moved to the front of the cache
	    moveToHead(node);

	    return node.value;
	  }

	  //put method
	  public void put(int key, int value) {
	    ListNode node = LRUhashtable.get(key);

	    if (node == null) {
	      // Item not found, create a new entry
	      ListNode newNode = new ListNode();
	      newNode.key = key;
	      newNode.value = value;

	      // Add to the hashtable and the actual list that represents the cache
	      LRUhashtable.put(key, newNode);
	      addToFront(newNode);
	      totalItemsInLRUCache++;

	      // If over capacity remove the LRU item
	      if (totalItemsInLRUCache > max) { //if the items go over capacity
	        removeLRUEntry(); //removes the least recently accessed
	      }
	    } else {
	      // If item is found in the cache, just update it and move it to the head of the list
	      node.value = value;
	      moveToHead(node);
	    }

	  }

	  //removes the LRUentry
	  private void removeLRUEntry() {
	    ListNode tail = popTail();

	    LRUhashtable.remove(tail.key);
	    --totalItemsInLRUCache; //decrements the total items in LRU
	  }

	  //removes the last item in the linked list
	  private ListNode popTail() {
	    ListNode tailItem = tail.prev;
	    removeFromList(tailItem);

	    return tailItem;
	  }

	  //method: adds the new entry to the front of the cache
	  private void addToFront(ListNode node) {
	    // new node inserted into the linked list
	    node.prev = head;
	    node.next = head.next;

	  
	    head.next.prev = node;
	    head.next = node;
	  }

	  //method: removes the linked list
	  private void removeFromList(ListNode node) {
	    ListNode savedPrev = node.prev;
	    ListNode savedNext = node.next;

	    savedPrev.next = savedNext;
	    savedNext.prev = savedPrev;
	  }

	  //method: moves the new entry to the front of the cache
	  private void moveToHead(ListNode node) { 
	    removeFromList(node);
	    addToFront(node);
	  }

	  //data type node
	  private class ListNode {
	    int key;
	    int value;

	    ListNode prev;
	    ListNode next;
	  }
	}