package virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	
	VirtualPet underTest = new VirtualPet("Ben", "A large black rat that seems to answer to any command you give him" );

	@Test
	public void assertThatPetCanBeFed() {
		underTest.feed();
		Integer check = underTest.getHunger();
		assertThat(check, is(100));
	}
	
	@Test
	public void assertThatPetCanBeWatered() {
		underTest.water();
		Integer check = underTest.getThirst();
		assertThat(check, is(100));
	}
	
	@Test
	public void assertThatPetCanBeTired() {
		underTest.rest();
		Integer check = underTest.getTiredness();
		assertThat(check, is(100));
	}
	
	@Test
	public void assertThatPetCanBePlayedWith() {
		underTest.play();
		Integer check = underTest.getBoredom();
		assertThat(check, is(100));
	}
	
	@Test
	public void assertThatThirstGrowsWithPlay() {
		underTest.play();
		Integer check = underTest.getThirst();
		assertThat(check, is(90));
	}
	
	@Test
	public void assertThatHungerGrowsWithRest() {
		underTest.rest();
		Integer check = underTest.getHunger();
		assertThat(check, is(75));
	}
	
	@Test
	public void assertThatHungerGrowsWithTick() {
		underTest.tick();
		Integer check = underTest.getHunger();
		assertTrue(check < 100);
	}
	
	@Test
	public void assertThatPetCanBeNamedWithDescription() {
		String check = underTest.getDescription();
		assertTrue(check != null);
	}
	
	@Test
	public void assertThatPetCanBeCreatedWithCustomAttributeLevels() {
		VirtualPet underTest2 = new VirtualPet("Audrey II", "Looks like a plant, but looks can be deceiving", 20, 80, 100, 60);
		Integer check = underTest2.getHunger();
		assertThat( check, is(20));
	}
}
