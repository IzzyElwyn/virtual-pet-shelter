package virtualpetshelter;

import java.util.Random;

public class VirtualPet {

	Random rand = new Random();

	private Integer hunger;
	private Integer thirst;
	private Integer tiredness;
	private Integer boredom;
	private String petName;
	private String description;

	public Integer getHunger() {
		return hunger;
	}

	public Integer getThirst() {
		return thirst;
	}

	public Integer getTiredness() {
		return tiredness;
	}

	public Integer getBoredom() {
		return boredom;
	}
	
	public String getPetName() {
		return petName;
	}

	public String getDescription() {
		return description;
	}
	

	public VirtualPet(String petName, String description) {
		this.petName = petName.toLowerCase();
		this.description = description.toLowerCase();
		this.hunger = 100;
		this.thirst = 100;
		this.tiredness = 100;
		this.boredom = 100;

	}

	public VirtualPet(String petName, String description, int hunger, int thirst, int tiredness, int boredom) {
		this.petName = petName.toLowerCase();
		this.description = description.toLowerCase();
		this.hunger = hunger;
		this.thirst = thirst;
		this.tiredness = tiredness;
		this.boredom = boredom;

	}

	public void feed() {
		if ((getHunger() + 25) > 100) {
			hunger = 100;
		} else {
			hunger = getHunger() + 25;
		}
	}

	public void water() {
		if ((getThirst() + 50) > 100) {
			thirst = 100;
		} else {
			thirst = getThirst() + 50;
		}

	}

	public void rest() {
		tiredness = 100;
		hunger = getHunger() - 25;

	}

	public void play() {
		if ((getBoredom() + 50) > 100) {
			boredom = 100;
		} else {
			boredom = getBoredom() + 50;
		}
		thirst = getThirst() - 10;
	}

	public void tick() {
		Integer impactAmount = rand.nextInt(10) + 1;
		if (getHunger() - impactAmount < 0) {
			hunger = 0;
		} else {
		hunger = getHunger() - impactAmount;
		}
		if (getThirst() - impactAmount < 0) {
			thirst = 0;
		} else {
		thirst = getThirst() - impactAmount;
		}
		if (getTiredness() - impactAmount < 0) {
			tiredness = 0;
		} else {
		tiredness = getTiredness() - impactAmount;
		} 
		if (getBoredom() - impactAmount < 0) {
			boredom = 0;
		} else {
		boredom = getBoredom() - impactAmount;
		}
		
	}


}
