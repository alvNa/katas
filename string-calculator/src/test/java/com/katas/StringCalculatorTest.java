package com.katas;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author AlvaroNav
 * */
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {
	@Mock
	private StringSplitter stringSplitter;
	private StringCalculator stringCalculator;
	
	@Before
	public void init(){
		stringCalculator = new StringCalculator();
		stringCalculator.setStringSplitter(stringSplitter);
	}
	
	@Test
	public void shouldAddZeroNumbers(){
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	public void shouldAddOneNumber(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(1, stringCalculator.add("1"));
	}
	
	@Test
	public void shouldAddTwoNumbers(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(3, stringCalculator.add("1,2"));
	}
	
	@Test
	public void shouldAddNNumbers(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(27, stringCalculator.add("1,2,3,5,7,9"));
	}
	
	@Test
	public void shouldAddTwoNumbersWithLines(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void shouldNotAddNegativeNumbers(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(2);
		list.add(-3);
		list.add(-4);
		when(stringSplitter.split(anyString())).thenReturn(list);
		stringCalculator.add("//;\n-1;2;-3;-4");
	}
	
	@Test
	public void shouldAddNumbersIgnoringBiggerThan1000(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1001);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(2, stringCalculator.add("2\n1001"));
	}
			
	@Test
	public void shouldAddAllowingDelimitersOfAnyLenght(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void shouldAllowSeveralDelimiters(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		when(stringSplitter.split(anyString())).thenReturn(list);
		assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
	}
}
