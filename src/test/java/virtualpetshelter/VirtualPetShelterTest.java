package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	
	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	
	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Church", "A cat with a strange vibe");
		pet2 = new VirtualPet("Ben", "A large black rat that seems to follow your orders");
	}
		
	@Test
	public void assertThatYouCanAddPetsToTheShelter() {
		underTest.dropOffHomelessPet(pet1);
		VirtualPet check = underTest.getPet("Church");
		assertThat (check, is(pet1));
	}
	
	@Test
	public void assertThatYouCanReturnACollectionOfPetsInTheShelter() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		Collection<?> animalList = underTest.getListOfPets();
		Collection<?> expectedResult = underTest.virtualPetsList;
		assertThat(animalList, is(expectedResult));
	}
	
	@Test
	public void assertThatAPetCanBeAdoptedOut() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.adoptAPet("Church");
		int check = underTest.virtualPets.size();
		assertThat(check, is(1));
	}
	
	@Test
	public void assertThatTickFunctionCanBeCalledForAllPetsInShelter() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.tick();
		Integer check = underTest.getPet("Church").getHunger();
		Integer check2 = underTest.getPet("Ben").getHunger();
		assertTrue(check < 100 && check2 < 100);
	}
	
	@Test
	public void assertThatPetsCanAllBeFedAtOnce() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.tick();
		underTest.feedPets();
		Integer check = underTest.getPet("Church").getHunger();
		Integer check2 = underTest.getPet("Ben").getHunger();
		assertTrue(check == 100 && check2 == 100);
	}
	
	@Test
	public void assertThatPetsCanAllBeWateredAtOnce() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.tick();
		underTest.waterPets();
		Integer check = underTest.getPet("Church").getThirst();
		Integer check2 = underTest.getPet("Ben").getThirst();
		assertTrue(check == 100 && check2 == 100);
	}
	
	@Test
	public void assertThatPetsCanBePlayedWithIndividually() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.tick();
		underTest.playWithPet("Church");
		Integer check = underTest.getPet("Church").getBoredom();
		Integer check2 = underTest.getPet("Ben").getBoredom();
		assertTrue(check == 100 && check2 < 100);
	}
	
	@Test
	public void assertThatPetsCanBePutDownForANapIndividually() {
		underTest.dropOffHomelessPet(pet1);
		underTest.dropOffHomelessPet(pet2);
		underTest.tick();
		underTest.putPetDownForNap("Church");
		Integer check = underTest.getPet("Church").getTiredness();
		Integer check2 = underTest.getPet("Ben").getTiredness();
		assertTrue(check == 100 && check2 < 100);
	}
}
