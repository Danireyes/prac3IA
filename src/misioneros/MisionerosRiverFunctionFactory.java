package misioneros;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
//import aima.core.environment.eightpuzzle.EPActionsFunction;
//import aima.core.environment.eightpuzzle.EPResultFunction;
//import aima.core.environment.eightpuzzle.EightPuzzleBoard;
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
			if (river.canMoveGap(MisionerosRiver.LEFTMM)) {
				actions.add(MisionerosRiver.LEFTMM);
			}
			if (river.canMoveGap(MisionerosRiver.LEFTCC)) {
				actions.add(MisionerosRiver.LEFTCC);
			}
			if (river.canMoveGap(MisionerosRiver.LEFTMC)) {
				actions.add(MisionerosRiver.LEFTMC);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTM)) {
				actions.add(MisionerosRiver.RIGHTM);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTC)) {
				actions.add(MisionerosRiver.RIGHTC);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTMM)) {
				actions.add(MisionerosRiver.RIGHTMM);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTCC)) {
				actions.add(MisionerosRiver.RIGHTCC);
			}
			if (river.canMoveGap(MisionerosRiver.RIGHTMC)) {
				actions.add(MisionerosRiver.RIGHTMC);
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
				newRiver.moveLeft("M");
				return newRiver;
			} else if (MisionerosRiver.LEFTC.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("C");
				return newRiver;
			} else if (MisionerosRiver.LEFTMM.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTMM)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("MM");
				return newRiver;
			} else if (MisionerosRiver.LEFTCC.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTCC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("CC");
				return newRiver;
			} else if (MisionerosRiver.LEFTMC.equals(a)
					&& river.canMoveGap(MisionerosRiver.LEFTMC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveLeft("MC");
				return newRiver;
			} else if (MisionerosRiver.RIGHTM.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTM)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("M");
				return newRiver;
			} else if (MisionerosRiver.RIGHTC.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("C");
				return newRiver;
			} else if (MisionerosRiver.RIGHTMM.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTMM)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("MM");
				return newRiver;
			} else if (MisionerosRiver.RIGHTCC.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTCC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("CC");
				return newRiver;
			} else if (MisionerosRiver.RIGHTMC.equals(a)
					&& river.canMoveGap(MisionerosRiver.RIGHTMC)) {
				MisionerosRiver newRiver = new MisionerosRiver(river);
				newRiver.moveRight("MC");
				return newRiver;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}