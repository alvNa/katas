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
public class RomanToNumberConverterTest {
	RomanToNumberConverter romanToNumberConverter;
	
	@Before
	public void init(){
		romanToNumberConverter = new RomanToNumberConverter();
	}
	
	@Test
	public void shouldGetOne(){
		assertEquals(Integer.valueOf(1), romanToNumberConverter.convert("I"));
	}
    
	@Test
	public void shouldGetTen(){
		assertEquals(Integer.valueOf(10), romanToNumberConverter.convert("X"));
	}
	
	@Test
	public void shouldGetSeven(){
		assertEquals(Integer.valueOf(7), romanToNumberConverter.convert("VII"));
	}
	
	@Test
	public void shouldGet34(){
		assertEquals(Integer.valueOf(34), romanToNumberConverter.convert("XXXIV"));
	}
	
	@Test
	public void shouldGet696(){
		assertEquals(Integer.valueOf(696), romanToNumberConverter.convert("DCXCVI"));
	}
	
	@Test
	public void shouldGet1001(){
		assertEquals(Integer.valueOf(1001), romanToNumberConverter.convert("MI"));
	}
}
