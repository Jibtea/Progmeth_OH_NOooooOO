package logic.stone;

import utils.GameUtilities;
import logic.game.GameManager;

public class WalkingStone extends Stone {

	// private static final WalkingStone WalkingStone = null;

	public WalkingStone(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void dig(int digPower) {
		///
		GameUtilities.removeStone(this);
		if (digPower > 1) {
			///edit
			//super
			GameManager.getInstance().setGameScore(GameManager.getInstance().getGameScore()+1);
			
		}
	}

	public void walk() {
		GameUtilities.moveWalkingRock(this);
	}
}
