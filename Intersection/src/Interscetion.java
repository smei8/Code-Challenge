import java.util.HashSet;
import java.util.Set;

public class Interscetion {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		Set<ListNode> visited = new HashSet<>();

		// travsering through listA and making each node as visited
		while (headA != null) {
			visited.add(headA);
			headA = headA.next;
		}

		// travsering through listB checking it with each node that is in visited
		while (headB != null) {
			// if there is a match return that node which is the intersection
			if (visited.contains(headB)) {
				return headB;
			}
			// else move on to the next node
			headB = headB.next;
		}

		// if none match up that means there is no intersection
		return null;
	}
}