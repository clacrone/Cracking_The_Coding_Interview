import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class LinkedList {
	Node head;
	
	public LinkedList(int d) {
		this.head = new Node(d);
	}
	
	public void append(Node n) {
		if (head == null) {
			head = n;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = n;
		}
	}
	
	public void append(int d) {
		Node end = new Node(d);
		append(end);
	}
	
	public void remove(int d) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.data == d) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		
		if (prev != null) {
			prev.next = curr.next;
		} else {
			head = curr.next;
		}
	}
	
	public Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next;
		}
		
		while(n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	public void deleteDups(Node n) {
		HashSet<Integer> dataSet = new HashSet<Integer>();
		Node prev = null;
		while (n != null) {
			if (dataSet.contains(n.data)) {
				prev.next = n.next;
			} else {
				dataSet.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}
	
	public void deleteDupsNoBuffer(Node head) {
		if (head == null) {
			return;
		}
		
		Node curr = head;
		while (curr != null) {
			Node runner = curr;
			while (runner.next != null) {
				if (runner.next.data == curr.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}
	
	public Node nthToLast(Node head, int k) {
		if (k < 0) {
			return null;
		}
		
		Node p1 = head;
		Node p2 = head;
		
		for (int i = 0; i < k-1; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		
		if (p2 == null) {
			return null;
		}
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	public boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	public Node partition(Node node, int d) {
		Node beforeStart = null;
		Node afterStart = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.data < d) {
				node.next = beforeStart;
				beforeStart = node;
			} else {
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		}
		
//		System.out.println("afterStart data: " + afterStart.data);
		Node head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
//		System.out.println("beforeStart data: " + beforeStart.data);
//		System.out.println("afterStart data: " + afterStart.data);
		
		beforeStart.next = afterStart;
		
		return head;
	}
	
	public Node findBeginning(Node head) {
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				break;
			}
		}
		
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Odd number of elements
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			
			if (top != slow.data) {
				return false;
			}
			
			slow = slow.next;
		}
		
		return true;
	}
	
	public void print() {
		Node curr = head;
		while(curr != null) {
			System.out.print("[" + curr.data + "] => ");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.print();
		
		System.out.println();
		
//		list.head = list.deleteNode(list.head, 3);
		
//		list.append(5);	
//		list.append(3);
//		list.append(4);	
//		
//		list.print();
//		System.out.println();
//		
//		list.deleteDupsNoBuffer(list.head);
//		
//		list.print();
//		System.out.println();
//		
//		Node result = list.nthToLast(list.head, 0);
//		System.out.println("result: " + result.data);
//		
//		list.deleteNode(list.head.next);
//		list.print();
//		System.out.println();
		
//		Node n = list.partition(list.head, 4);
//		while (n != null) {
//			System.out.print("[" + n.data + "] => ");
//			n = n.next;
//		}
		
//		list.append(4);
//		list.append(3);
//		list.append(2);
//		list.append(1);
//		boolean result = list.isPalindrome(list.head);
//		System.out.println("result: " + result);
	}
}
