package logic.stone;

import utils.GameUtilities;

public class HardStone extends Stone {
	protected int durability;
//	public HardStone(int posX,int posY) {
//		super(posX,posY);
//	}
	public HardStone(int posX,int posY,int durability) {
		super(posX,posY);
		setDurability(durability);
	}
	public HardStone(int posX, int posY) {
		// TODO Auto-generated constructor stub
		super(posX, posY);
	}
	////edit this
	public void dig(int digPower) {
		int setValue=this.getDurability()-digPower;
		if(setValue<=0) {
			this.setDurability(0);
			GameUtilities.removeStone(this);
		}else {
			this.setDurability(setValue);
		}
	}
	

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
//		this.durability = durability;
		if(durability>5) {
			this.durability=5;
		}
		else if (durability<0) {
			this.durability=0;
		}
		else {
			this.durability=durability;
		}
	}
	
}
