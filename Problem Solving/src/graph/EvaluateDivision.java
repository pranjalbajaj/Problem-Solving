/**
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 */

package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {

	public static void main(String[] args) {
		
		List<List<String>> equations = new ArrayList<List<String>>();
		
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("a");
		l1.add("b");
		
		ArrayList<String> l2 = new ArrayList<String>();
		l2.add("b");
		l2.add("c");
		
		equations.add(l1);
		
		equations.add(l2);
		
		double[] values = new double[] {2.0, 3.0};
		
		List<List<String>> queries = new ArrayList<List<String>>();
		
		ArrayList<String> q1 = new ArrayList<String>();
		q1.add("a");
		q1.add("c");
		
		ArrayList<String> q2 = new ArrayList<String>();
		q2.add("b");
		q2.add("a");
		
		ArrayList<String> q3 = new ArrayList<String>();
		q3.add("a");
		q3.add("e");
		
		ArrayList<String> q4 = new ArrayList<String>();
		q4.add("a");
		q4.add("a");
		
		ArrayList<String> q5 = new ArrayList<String>();
		q5.add("x");
		q5.add("x");
		
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		queries.add(q5);
		
		double[] result = calcEquation(equations, values, queries);
		
		System.out.println(Arrays.toString(result));
		
	}

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		HashMap<String, ArrayList<Node>> graph = createGraph(equations, values);

		double[] result = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {

			result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
		}

		return result;
	}

	private static double dfs(HashMap<String, ArrayList<Node>> graph, String start, String end,
			HashSet<String> visited) {

		if (graph.containsKey(start) && graph.containsKey(end)) {

			ArrayList<Node> adjNodeList = graph.get(start);

			if (start.equals(end)) {

				return 1;
			}

			for (int i = 0; i < adjNodeList.size(); i++) {

				Node node = adjNodeList.get(i);

				if (visited.contains(node.key)) {

					continue;
				}

				visited.add(node.key);

				double result = dfs(graph, node.key, end, visited);

				if (result != -1)

					return result * node.value;
			}

		}
		return -1;
	}

	private static HashMap<String, ArrayList<Node>> createGraph(List<List<String>> equations, double[] values) {

		HashMap<String, ArrayList<Node>> graph = new HashMap();

		for (int i = 0; i < equations.size(); i++) {

			graph.putIfAbsent(equations.get(i).get(0), new ArrayList<Node>());

			graph.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1), values[i]));

			graph.putIfAbsent(equations.get(i).get(1), new ArrayList<Node>());

			graph.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0), 1 / values[i]));
		}

		return graph;
	}

	static class Node {

		String key;

		double value;

		public Node(String k, double v) {

			this.key = k;

			this.value = v;
		}
	}

}
