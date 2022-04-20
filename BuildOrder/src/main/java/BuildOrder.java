import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;

public class BuildOrder {

	public List<Character> findBuildOrder(char[][] projects) {

		Set<Character> tempMark = new HashSet<Character>();
		Set<Character> permMark = new HashSet<Character>();
		List<Character> result = new LinkedList<Character>();

		// doing a dfs from any node that doesn't have a permanent mark
		for (int i = 0; i < projects.length; i++) {
			if (!permMark.contains(i)) {
				// recursive function to add/remove tempMark/permMark and add to result
				built(i, projects, tempMark, permMark, result);
			}
		}

		return result;
	}

	public void built(int project, char[][] projects, Set<Character> tempMark, Set<Character> permMark,
			List<Character> result) {

		if (tempMark.contains(project))
			throw new RuntimeErrorException(null);

		if (!permMark.contains(project)) {
			tempMark.add((char) project);

			for (int i : projects[project]) {
				built(i, projects, tempMark, permMark, result);
			}
			permMark.add((char) project);
			tempMark.remove(project);
			result.add((char) project);
		}
	}

	public static void main(String[] args) {

		// String[] projects = new String[] {'a', 'b', 'c', 'd', 'e', 'f'};
		char[][] dependencies = new char[][] { { 'a', 'd' }, { 'f', 'b' }, { 'b', 'd' }, { 'f', 'a' }, { 'd', 'c' } };

		BuildOrder order = new BuildOrder();
		System.out.println(order.findBuildOrder(dependencies));

	}
}
