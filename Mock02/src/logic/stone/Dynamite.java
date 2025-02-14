package logic.stone;

import java.util.ArrayList;

import utils.GameUtilities;

public class Dynamite extends Stone{

	public Dynamite(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	public void destroy() {
		
		ArrayList<Stone> stoneBomb = GameUtilities.getAdjacentStones(this.posX, this.posY);
		for(int i=0;i<stoneBomb.size();i++) {
			Stone dynamite = new Stone(stoneBomb.get(i).getPosX(), stoneBomb.get(i).getPosY());
			GameUtilities.removeStone(dynamite);
		}
		GameUtilities.removeStone(this);
		///มาดูว่าเป็นหินประเภทไหน
	}
	
}
