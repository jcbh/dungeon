package game;

import java.util.ArrayList;
import java.util.List;

import deck.Card;

public class PlayerStatus {

	private int health;
	private int weaponPower;
	private int actualRound;
	private List<Integer> scapes;
	private List<Card> weaponStatus;
	private boolean healthPotionOnThisRound;
	private boolean addWeaponOnThisRound;
	
	public PlayerStatus() {
		this.health = 20;
		this.weaponPower = 0;
		this.actualRound = 0;
		this.scapes = new ArrayList<Integer>();
		this.weaponStatus = new ArrayList<Card>();
		healthPotionOnThisRound=false;
		addWeaponOnThisRound=false;
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

	public List<Card> getWeaponStatus() {
		return weaponStatus;
	}

	public void setWeaponStatus(List<Card> weaponStatus) {
		this.weaponStatus = weaponStatus;
	}

	public boolean isHealthPotionOnThisRound() {
		return healthPotionOnThisRound;
	}

	public void setHealthPotionOnThisRound(boolean healthPotionOnThisRound) {
		this.healthPotionOnThisRound = healthPotionOnThisRound;
	}

	public boolean isAddWeaponOnThisRound() {
		return addWeaponOnThisRound;
	}

	public void setAddWeaponOnThisRound(boolean addWeaponOnThisRound) {
		this.addWeaponOnThisRound = addWeaponOnThisRound;
	}
	
	
}
