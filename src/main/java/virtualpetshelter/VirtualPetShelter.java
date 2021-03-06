package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {
	
	Map<String, VirtualPet> virtualPets = new HashMap<>();

	public void dropOffHomelessPet(VirtualPet pet) {
		virtualPets.put(pet.getPetName(), pet);
		
	}

	public VirtualPet getPet(String petName) {
		return virtualPets.get(petName.toLowerCase());
	}

	public Collection<VirtualPet> getListOfPets() {
		return virtualPets.values();
	}

	public void adoptAPet(String petName) {
		virtualPets.remove(petName.toLowerCase());
	}

	public void tick() {
		for (Entry<String, VirtualPet> entry : virtualPets.entrySet()) {
			entry.getValue().tick();
		}
		
	}

	public void feedPets() {
		for (Entry<String, VirtualPet> entry : virtualPets.entrySet()) {
			entry.getValue().feed();
		}
		
	}

	public void waterPets() {
		for (Entry<String, VirtualPet> entry : virtualPets.entrySet()) {
			entry.getValue().water();
		}
		
	}

	public void playWithPet(String petName) {
		virtualPets.get(petName.toLowerCase()).play();
		
	}

	public void putPetDownForNap(String petName) {
		virtualPets.get(petName.toLowerCase()).rest();
		
	}
	
	

}
