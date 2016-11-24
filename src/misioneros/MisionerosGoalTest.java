package misioneros;

//import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.GoalTest;
import misioneros.MisionerosRiver.Position;

/**
 * @author Ravi Mohan
 * 
 */
public class MisionerosGoalTest implements GoalTest {
	MisionerosRiver goal = new MisionerosRiver(new int[] { 0, 0, 3, 3}, Position.Right);

	public boolean isGoalState(Object state) {
		MisionerosRiver river = (MisionerosRiver) state;
		return river.equals(goal);
	}
}