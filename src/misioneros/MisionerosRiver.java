package misioneros;

import java.util.ArrayList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * @author R. Lunde
 */
public class MisionerosRiver {

	

	public enum Position {Right, Left;
		 static String toString(Position pos) {
			if (pos == Right) {
				return "derecha";
			}
			else {
				return "izquierda";
			}
		 }
	}
	
	private Position boatPosition;
	public static Action LEFTM = new DynamicAction("LeftM");

	public static Action RIGHTM = new DynamicAction("RightM");
	
	public static Action LEFTC = new DynamicAction("LeftC");

	public static Action RIGHTC = new DynamicAction("RightC");

	private int[] NMNCinBank;//number of misioners number of canibals on the river bank
	//
	// PUBLIC METHODS
	//


	public MisionerosRiver() {
		NMNCinBank = new int[] { 3,3,0,0 };
		boatPosition = Position.Left;
	}

	public MisionerosRiver(int[] NMNCinBank, Position pos) {
		this.NMNCinBank = NMNCinBank;
		this.boatPosition = pos;
	}

	public MisionerosRiver(MisionerosRiver copyRiver) {
		this(copyRiver.getNMNCinBank(), copyRiver.getBoatPosition());
	}

	public Position getBoatPosition() {
		return boatPosition;
	}
	
	
	public int[] getNMNCinBank() {
		return NMNCinBank;
	}
	
	/*public int[] getState() {
		return state;
	}*/

	public void moveRight(String character) {
		switch (character) {
		case "misionero":
			if(canMoveGap(this.RIGHTM)) {
				this.NMNCinBank[0]--;
				this.NMNCinBank[2]++;
			}
			else {
				System.err.println("No se puede mover al misionero");
			}
			break;
		case "canibal":
			if(canMoveGap(this.RIGHTC)) {
				this.NMNCinBank[1]--;
				this.NMNCinBank[3]++;
			}
			else {
				System.err.println("No se puede mover al canibal");
			}
			break;
		}
	}

	public void moveLeft(String character) {
		switch (character) {
		case "misionero":
			if(canMoveGap(this.LEFTM)){
				this.NMNCinBank[2]--;
				this.NMNCinBank[0]++;
				changeBoatPosition();
			}
			else {
				System.err.println("No se puede mover al misionero");
			}
			break;
		case "canibal":
			if(canMoveGap(this.LEFTC)) {
				this.NMNCinBank[3]++;
				this.NMNCinBank[1]--;
				changeBoatPosition();
			}
			else {
				System.err.println("No se puede mover al canibal");
			}
			break;
		}
	}
	
	private void changeBoatPosition() {
		if (this.boatPosition == Position.Right) {
			this.boatPosition = Position.Left;
		}
		else {
			this.boatPosition = Position.Right;
		}
	}

	public boolean canMoveGap(javax.swing.Action where) {
		boolean retVal = true;
		if (where.equals(LEFTM)) {
			if (this.boatPosition == Position.Right){retVal = false;}
			if((this.NMNCinBank[2] < 0) && ((this.NMNCinBank[2] - 1) < this.NMNCinBank[3])) {
				retVal = false;
			}
		}
		else if (where.equals(LEFTC)) {
			if (this.boatPosition == Position.Right){retVal = false;}
			if((this.NMNCinBank[3] < 0) && (this.NMNCinBank[0] < (this.NMNCinBank[1] + 1))) {
				retVal = false;
			}
		}
		else if (where.equals(RIGHTM)) {
			if (this.boatPosition == Position.Left) {retVal = false;}
			if((this.NMNCinBank[0] < 0) && ((this.NMNCinBank[0] - 1) < this.NMNCinBank[1])) {
				retVal = false;
			}
		}
		else {
			if (this.boatPosition == Position.Left) {retVal = false;}
			if((this.NMNCinBank[1] < 0) && (this.NMNCinBank[2] < (this.NMNCinBank[3] + 1))) {
				retVal = false;
			}
		}
		return retVal;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		MisionerosRiver aRiver = (MisionerosRiver) o;

		if (aBoard.getNMNCinBank() != this.NMNCinBank && aRiver.getBoatPosition() != this.boatPosition) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result += this.NMNCinBank[0] * 8;
		result += this.NMNCinBank[1];
		result -= this.NMNCinBank[2] * 8;
		result -= this.NMNCinBank[3];
		if(this.boatPosition == Position.Left) {
			result += 1;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Hay " + this.NMNCinBank[0] + " misioneros y " + this.NMNCinBank[1]
				+ " canibales en la izquierda, y hay " + this.NMNCinBank[2] + " misioneros y " + this.NMNCinBank[3]
						+ " canibales en la derecha. Y el barco está en la " + Position.toString(this.boatPosition) + ".";
	}

	
}