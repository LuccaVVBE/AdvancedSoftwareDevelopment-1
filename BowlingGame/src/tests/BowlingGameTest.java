package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.BowlingGame;

public class BowlingGameTest {
	BowlingGame game;
	
	@BeforeEach
	public void before() {
		game = new BowlingGame();
	}
	
	private void rollMany(int n, int pins) {
		for(int i = 0;i<n;i++)
			game.roll(pins);
	}
	
	@ParameterizedTest
	@CsvSource ({"0,0","1,20"})

	public void testSameNoOfPins(int number, int expected) {
		rollMany(20, number);
		Assertions.assertEquals(expected, game.score());
	}
	
	@Test
	public void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17,0);
		Assertions.assertEquals(16, game.score());
	}
	
	private void rollSpare() {
		rollMany(2, 5);
	}
	
	public void testOneStrike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		rollMany(16,0);
	}
	
	@Test
	public void testTwoSpare() {
		rollSpare();
		rollSpare();
		game.roll(3);
		rollMany(15,0);
		Assertions.assertEquals(31, game.score());
	}
	@Test
	public void testAllSpare() {
		for(int i=0;i<10;i++) {
			rollSpare();
		}
		game.roll(5);
		Assertions.assertEquals(150, game.score());
	}
	
	@Test
	public void testAllStrike() {
		for(int i=0;i<12;i++) {
			rollStrike();
		}
		Assertions.assertEquals(300, game.score());
	}

	private void rollStrike() {
		// TODO Auto-generated method stub
		game.roll(10);
	}
	
	@Test
	public void testScenario() {
		int[] pins = {};
		for(int i = 0;i<pins.length;i++) {
			game.roll(pins[i]);
		}
		Assertions.assertEquals(133, game.score());
	}
	
}
