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
		
		//if the node already has a tempMark then it will result in a cycle so it should throw an error
		if (tempMark.contains(project))
			throw new RuntimeErrorException(null);
		
		//if the node does not have a permMark
		if (!permMark.contains(project)) {
			//then we can add a permMark
			tempMark.add((char) project);
			
			//iterate through any dependencies if any
			for (int i : projects[project]) {
				//recursive called on the dependencies
				built(i, projects, tempMark, permMark, result);
			}
			
			permMark.add((char) project);	//adds the node to permMark	
			tempMark.remove(project);		//remove the same node from tempMark
			result.add((char) project);		//adds to result 
		}
	}
}

	
