package com.katas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author AlvaroNav
 * */
public class StringSplitterTest {
	private StringSplitter stringSplitter;
	
	@Before
	public void init(){
		stringSplitter = new StringSplitter();
	}
	@Test
	public void shouldSplitZeroNumbers(){
		assertEquals(new ArrayList<Integer>(), stringSplitter.split(""));
	}
	
	@Test
	public void shouldSplitNumbersWithLines(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(list, stringSplitter.split("1\n2,3"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void shouldSplitNumbersWithOnlyOneDelimiter(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		stringSplitter.split("1,\n2");
	}
	
	@Test
	public void shouldSplitNumbersWithDeclaredDelimiter(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		assertEquals(list, stringSplitter.split("//[;]\n1;2"));
	}
	
	@Test
	public void shouldSplitNumbersNegatives(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		list.add(2);
		list.add(-3);
		list.add(-4);
		assertEquals(list, stringSplitter.split("//[;]\n-1;2;-3;-4"));
	}
	
	@Test
	public void shouldAllowDelimitersOfAnyLenght(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(list, stringSplitter.split("//[***]\n1***2***3"));
	}
	
	@Test
	public void shouldAllowSeveralDelimiters(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(list, stringSplitter.split("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void shouldAllowSeveralDelimitersOfAnyLenght(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertEquals(list, stringSplitter.split("//[****][%%%]\n1****2%%%3"));
	}
	
}
