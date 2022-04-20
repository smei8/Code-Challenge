
public class Main {

	public static void main(String[] args) {

		// String[] projects = new String[] {'a', 'b', 'c', 'd', 'e', 'f'};
		char[][] dependencies = new char[][] { { 'a', 'd' }, { 'f', 'b' }, { 'b', 'd' }, { 'f', 'a' }, { 'd', 'c' } };

		BuildOrder order = new BuildOrder();
		System.out.println(order.findBuildOrder(dependencies));

	}
}

