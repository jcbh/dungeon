package game;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatus {

	private int health;
	private int weaponPower;
	private int actualRound;
	private List<Integer> scapes;
	
	public PlayerStatus() {
		this.health = 20;
		this.weaponPower = 0;
		this.actualRound = 0;
		this.scapes = new ArrayList<Integer>();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWeaponPower() {
		return weaponPower;
	}

	public void setWeaponPower(int weaponPower) {
		this.weaponPower = weaponPower;
	}

	public int getActualRound() {
		return actualRound;
	}

	public void setActualRound(int actualRound) {
		this.actualRound = actualRound;
	}

	public List<Integer> getScapes() {
		return scapes;
	}

	public void setScapes(List<Integer> scapes) {
		this.scapes = scapes;
	}
	
	
}
