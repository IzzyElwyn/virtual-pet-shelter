package virtualpetshelter;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int userOption;

		VirtualPetShelter scaryShelter = new VirtualPetShelter();
		VirtualPet critter1 = new VirtualPet("Church", "A grey cat with flashing yellow eyes and a terrible smell...",
				98, 86, 75, 96);
		VirtualPet critter2 = new VirtualPet("Ben", "A large black rat that seems to understand and obey orders", 93,
				59, 62, 81);
		VirtualPet critter3 = new VirtualPet("Audrey2", "It looks like a plant, but looks can be deceiving... ", 80, 40,
				73, 36);
		VirtualPet critter4 = new VirtualPet("Stripe", "A small green gremlin that doesn't look particularly cuddly",
				92, 34, 63, 91);

		scaryShelter.dropOffHomelessPet(critter1);
		scaryShelter.dropOffHomelessPet(critter2);
		scaryShelter.dropOffHomelessPet(critter3);
		scaryShelter.dropOffHomelessPet(critter4);

		Collection<VirtualPet> pets = scaryShelter.getListOfPets();

		System.out.println("Welcome to Izzy's Virtual Pet Shelter for Abandoned Scary Critters!\n");

		System.out.println("Our current residents are:\n");
		do {
			System.out.println("Name\t|Hunger\t|Thirst\t|Boredom |Tiredness");
			System.out.println("--------|-------|-------|--------|--------");
			for (VirtualPet pet : pets) {
				System.out.println(pet.getPetName() + "\t|" + pet.getHunger() + "\t|" + pet.getThirst() + "\t|"
						+ pet.getBoredom() + "\t |" + pet.getTiredness());
			}
			
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("Press 1 to feed the pets\n"
							+ "Press 2 to water the pets\n"
							+ "Press 3 to play with a pet\n"
							+ "Press 4 to put a pet down for a nap\n"
							+ "Press 5 to adopt a pet\n"
							+ "Press 6 to process a newly dropped-off pet\n"
							+ "Press 0 to exit\n");
			userOption = input.nextInt();
			input.nextLine();

			switch (userOption) {
			case 1:
				scaryShelter.feedPets();
				scaryShelter.tick();
				break;
			case 2:
				scaryShelter.waterPets();
				scaryShelter.tick();
				break;
			case 3:
				System.out.println("\nWhich pet would you like to play with?");
				String chosenPet = input.nextLine();
				scaryShelter.playWithPet(chosenPet);
				scaryShelter.tick();
				break;
			case 4:
				System.out.println("\nWhich pet would you like to put down for a nap?");
				String sleepyPetChoice = input.nextLine();
				scaryShelter.putPetDownForNap(sleepyPetChoice);
				scaryShelter.tick();
				break;
			case 5:
				System.out.println("\nWhich pet would you like to adopt?");
				String petToAdopt = input.nextLine();
				scaryShelter.adoptAPet(petToAdopt);
				scaryShelter.tick();
				break;
			case 6: System.out.println("\nWhat is the name of the pet being admitted?");
					String intakePetName = input.nextLine();
					System.out.println("\nPlease provide a brief description of the pet being admitted");
					String intakeDescription = input.nextLine();
					VirtualPet dropOffPet = new VirtualPet(intakePetName, intakeDescription);
					scaryShelter.dropOffHomelessPet(dropOffPet);
					scaryShelter.tick();
				break;
			default:
				scaryShelter.tick();
				System.out.println(" ");
			}

		} while (userOption != 0);
		
		System.out.println("We appreciate your help with our unusual critters. ");
		System.out.println("Have a spooky day");
		input.close();
	}

}
