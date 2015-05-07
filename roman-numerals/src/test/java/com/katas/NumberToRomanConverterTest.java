package com.katas;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author AlvaroNav
 */
@RunWith(value=MockitoJUnitRunner.class)
public class NumberToRomanConverterTest {
	private NumberToRomanConverter numberToRomanConverter = new NumberToRomanConverter();
	
	@Before
	public void init(){
		numberToRomanConverter = new NumberToRomanConverter();
	}
	
	@Test
	public void shouldGetOne(){
		assertEquals("I", numberToRomanConverter.convert(1));
	}
    
	@Test
	public void shouldGetTen(){
		assertEquals("X", numberToRomanConverter.convert(10));
	}
	
	@Test
	public void shouldGetSeven(){
		assertEquals("VII", numberToRomanConverter.convert(7));
	}
	
	@Test
	public void shouldGet34(){
		assertEquals("XXXIV", numberToRomanConverter.convert(34));
	}
	
	@Test
	public void shouldGet696(){
		assertEquals("DCXCVI", numberToRomanConverter.convert(696));
	}
	
	@Test
	public void shouldGet1001(){
		assertEquals("MI", numberToRomanConverter.convert(1001));
	}
}
