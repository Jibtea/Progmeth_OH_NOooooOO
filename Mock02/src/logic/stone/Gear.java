package logic.stone;

import logic.game.GameManager;
import utils.GameUtilities;

public class Gear extends HardStone {
	private int upgradeValue;
	
//////
	public int getUpgradeValue() {
		return upgradeValue;
	}
	public void setUpgradeValue(int upgradeValue) {
		if(upgradeValue<1) {
			this.upgradeValue=1;////
		}else {
			this.upgradeValue=upgradeValue;
		}
	}
	//////
	public Gear(int posX, int posY, int upgradeValue) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
		this.setDurability(2);
		this.setUpgradeValue(upgradeValue);
	}
	
	public Gear (int posX,int posY) {
		super(posX, posY);
		this.setDurability(2);
		this.setUpgradeValue(1);
	}
	
	public void destroy() {
		//System.out.println(this.upgradeValue);'
//		GameManager.getInstance().addDigPower(this.getUpgradeValue());
		GameUtilities.removeStone(this);    
		
	}
	
	@Override
	public void dig(int digPower) {
		int setValue=this.getDurability()-digPower;
		if(setValue<=0) {
			GameManager.getInstance().addDigPower(this.getUpgradeValue());
			this.setDurability(0);
			GameUtilities.removeStone(this);
		}else {
			this.setDurability(setValue);
		}
	}
	
	
	
	
	
}
