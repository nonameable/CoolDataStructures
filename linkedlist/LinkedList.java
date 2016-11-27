package linkedlist;

import java.util.Hashtable;

/* Class that represents and Singly LinkedList*/
public class LinkedList {

	/* head Node of the linkedList */
	Node head;

	int size;

	public LinkedList() {
		this.size = 0;
	}

	public LinkedList(Node head) {
		this.head = head;
		this.size = 0;
	}

	public void addToTail(int value) {

		if (size == 0) {
			head = new Node(value);
		} else {
			Node toAdd = new Node(value);
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = toAdd;
		}
		size = size + 1;

	}

	public void addToHead(int value) {
		if (size == 0) {
			head = new Node(value);
		} else {
			Node toAdd = new Node(value);
			toAdd.next = head;
			head = toAdd;
		}
		size = size + 1;

	}

	public void deleteTail() {
		if (size == 0) {

		} else if (size <= 1) {
			head = null;
			size = size - 1;
		} else {
			Node n = head;
			Node n2 = n.next;
			while (n2.next != null) {
				n = n2;
				n2 = n2.next;
			}
			n.next = null;
			size = size - 1;
		}

	}

	/*
	 * Only deletes when the value is found in the list. Otherwise it does nothing
	 */
	public void delete(int value) {
		if (value == head.value) {
			head = head.next;
		} else {
			Node n = head;
			Node n2 = n.next;
			while (n2 != null && n2.value != value) {
				n = n2;
				n2 = n2.next;
			}
			if (n2 != null) {
				n.next = n2.next;
				size = size - 1;
			}
		}
	}

	public String toString() {
		String representation = "";
		Node n = head;
		while (n != null) {
			representation += " " + n.value;
			n = n.next;
		}
		return representation;

	}

	public void removeDuplicates() {
		if (size != 2) {
			// I will make use of the java collections framework here: Hash Table,
			// here we go bitches
			Hashtable<Integer, Integer> table = new Hashtable<>();
			Node n = head;
			table.put(n.value, n.value);
			Node n2 = n.next;
			while (n2 != null) {

				Integer test = table.get(n2.value);
				if (test != null) {
					n.next = n2.next; // deletes n2
					n2 = n.next;
				} else {
					table.put(n2.value, n2.value);
					n = n2;
					n2 = n2.next;
				}

			}
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addToTail(0);
		System.out.println(list.toString());
		list.addToTail(1);
		list.addToTail(2);
		list.addToTail(3);
		System.out.println("adds nodes");
		System.out.println(list.toString());
		list.addToHead(-1);
		System.out.println("adds to head");
		System.out.println(list.toString());
		list.delete(-1);
		System.out.println("deletes first");
		System.out.println(list.toString());
		list.delete(3);
		System.out.println("deletes last");
		System.out.println(list.toString());
		list.addToTail(3);
		System.out.println("adds item just deleted");
		System.out.println(list.toString());
		list.delete(4);
		System.out.println("tries to delete item not found in the list");
		System.out.println(list.toString());

		System.out.println("------ Removing duplicates testing -------------");
		list.addToTail(2);
		list.addToTail(0);
		System.out.println("adds repeated items");
		System.out.println(list.toString());
		list.addToTail(4);
		list.addToTail(1);
		System.out.println("adds duplicate and new item");
		System.out.println(list.toString());
		list.removeDuplicates();
		System.out.println("removes duplicates");
		System.out.println(list.toString());

	}

}
