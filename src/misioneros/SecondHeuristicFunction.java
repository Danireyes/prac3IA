package misioneros;

//import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.HeuristicFunction;
//import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 */
public class SecondHeuristicFunction implements HeuristicFunction {

	public double h(Object state) {
		MisionerosRiver river = (MisionerosRiver) state;
		int retVal = 0;
		retVal += river.getNMNCinBank()[0];
		return retVal;
	}
}