package com.katas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author AlvaroNav
 * */
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

	@Mock
	private FizzBuzz fizzBuzz;

	@Before
	public void init() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	public void shouldHaveDivisibleBy3Number() {
		for (int i = 3; i < 30; i += 3) {
			assertEquals(true, fizzBuzz.isFizz(i));
		}
	}

	@Test
	public void shouldHaveDivisibleBy5Number() {
		for (int i = 5; i < 30; i += 5) {
			assertEquals(true, fizzBuzz.isBuzz(i));
		}
	}

	@Test
	public void shouldHaveDivisibleBy3And5Number() {
		for (int i = 15; i < 60; i += 15) {
			assertEquals(true, fizzBuzz.isFizzBuzz(i));
		}
	}

	@Test
	public void shouldHaveFizz() {
		int[] array = { 3, 6, 12, 18 };

		for (int i : array) {
			assertEquals(FizzBuzz.FIZZ_VALUE, fizzBuzz.toFizzBuzz(i));
		}
	}

	@Test
	public void shouldHaveBuzz() {
		for (int i = 5; i < 30; i += 5) {
			assertEquals(FizzBuzz.BUZZ_VALUE, fizzBuzz.toFizzBuzz(i));
		}
	}

	@Test
	public void shouldHaveFizzBuzz() {
		for (int i = 15; i < 60; i += 15) {
			assertEquals(FizzBuzz.FIZZBUZZ_VALUE, fizzBuzz.toFizzBuzz(i));
		}
	}

	@Test
	public void shouldHaveFizzBuzzArray() {
		int[] array = { 1, 2, 3, 5, 10, 15, 18, 20, 21, 22 };
		String[] result = { "1", "2", FizzBuzz.FIZZ_VALUE, FizzBuzz.BUZZ_VALUE,
				FizzBuzz.BUZZ_VALUE, FizzBuzz.FIZZBUZZ_VALUE,
				FizzBuzz.FIZZ_VALUE, FizzBuzz.BUZZ_VALUE, FizzBuzz.FIZZ_VALUE,
				"22" };

		assertArrayEquals(result, fizzBuzz.toFizzBuzz(array));
	}
}
