package misioneros;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EPActionsFunction;
import aima.core.environment.eightpuzzle.EPResultFunction;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class MisionerosRiverFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}

	private static class EPActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			MisionerosRiver river = (MisionerosRiver) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (river.canMoveGap(MisionerosRiver.LEFTM)) {
				actions.add(MisionerosRiver.LEFTM);
			}
			if (river.canMoveGap(MisionerosRiver.LEFTC)) {
				actions.add(MisionerosRiver.LEFTC);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTM)) {
				actions.add(MisionerosRiver.RIGHTM);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTC)) {
				actions.add(MisionerosRiver.RIGHTC);
			}

			return actions;
		}
	}

	private static class EPResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			MisionerosRiver river = (MisionerosRiver) s;

			if (MisionerosRiver.LEFTM.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTM)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("misionero");
				return newRiver;
			} else if (MisionerosRiver.LEFTC.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("canibal");
				return newRiver;
			} else if (MisionerosRiver.RIGHTM.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTM)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("misioneros");
				return newRiver;
			} else if (MisionerosRiver.RIGHTC.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("canibal");
				return newRiver;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}