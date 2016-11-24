package misioneros;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
/*import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.environment.eightpuzzle.MisplacedTilleHeuristicFunction;*/
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
//import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
//import aima.core.search.uninformed.IterativeDeepeningSearch;

/**
 * @author Ravi Mohan
 * 
 */

public class MisionerosDemo {
	static MisionerosRiver river = new MisionerosRiver();

	public static void main(String[] args) {
		misionerosDLSDemo();
		misionerosGreedyBestFirstFirstDemo();
		misionerosGreedyBestFirstSecondDemo();
		misionerosAStarFirstDemo();
		misionerosAStarSecondDemo();
	}

	private static void misionerosDLSDemo() {
		System.out.println("\nMisioneros recursive DLS (9) -->");
		try {
			Problem problem = new Problem(river, MisionerosRiverFunctionFactory
					.getActionsFunction(), MisionerosRiverFunctionFactory
					.getResultFunction(), new MisionerosGoalTest());
			Search search = new DepthLimitedSearch(9);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void misionerosGreedyBestFirstFirstDemo() {
		System.out
				.println("\nMisioneros Greedy Best First Search (FirstHeursitic)-->");
		try {
			Problem problem = new Problem(river,
					MisionerosRiverFunctionFactory.getActionsFunction(),
					MisionerosRiverFunctionFactory.getResultFunction(),
					new MisionerosGoalTest());
			Search search = new GreedyBestFirstSearch(new GraphSearch(),
					new FirstHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void misionerosGreedyBestFirstSecondDemo() {
		System.out
				.println("\nMisioneros Greedy Best First Search (SecondHeursitic)-->");
		try {
			Problem problem = new Problem(river,
					MisionerosRiverFunctionFactory.getActionsFunction(),
					MisionerosRiverFunctionFactory.getResultFunction(),
					new MisionerosGoalTest());
			Search search = new GreedyBestFirstSearch(new GraphSearch(),
					new SecondHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void misionerosAStarFirstDemo() {
		System.out
				.println("\nMisioneros AStar Search (FirstHeursitic)-->");
		try {
			Problem problem = new Problem(river, MisionerosRiverFunctionFactory
					.getActionsFunction(), MisionerosRiverFunctionFactory
					.getResultFunction(), new MisionerosGoalTest());
			Search search = new AStarSearch(new GraphSearch(),
					new FirstHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void misionerosAStarSecondDemo() {
		System.out
				.println("\nMisioneros AStar Search (SecondHeursitic)-->");
		try {
			Problem problem = new Problem(river, MisionerosRiverFunctionFactory
					.getActionsFunction(), MisionerosRiverFunctionFactory
					.getResultFunction(), new MisionerosGoalTest());
			Search search = new AStarSearch(new GraphSearch(),
					new FirstHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}

}