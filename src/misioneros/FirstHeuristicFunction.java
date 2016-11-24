package misioneros;

//import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.HeuristicFunction;
//import aima.core.util.datastructure.XYLocation;
import misioneros.MisionerosRiver.Position;

/**
 * @author Ravi Mohan
 * 
 */
public class FirstHeuristicFunction implements HeuristicFunction {

	public double h(Object state) {
		MisionerosRiver river = (MisionerosRiver) state;
		int retVal = 0;
		for (int i = 0; i < 2; i++) {
			retVal += river.getNMNCinBank()[i];
		}
		if (river.getBoatPosition() == Position.Left) {
			retVal += 1;
		}
		return retVal;

	}
}