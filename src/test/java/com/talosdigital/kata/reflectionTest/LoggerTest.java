package com.talosdigital.kata.reflectionTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LoggerTest{
	
	@Test
	public void primitiveTest() throws IllegalArgumentException, IllegalAccessException  {
		int i = 10;
		String result = Logger.getObjectInfo(i);
		String expected = "Type: java.lang.Integer\n\tValue : 10\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void arrayTest() throws IllegalArgumentException, IllegalAccessException {
		Integer[] i = new Integer[]{0,1};
		String result = Logger.getObjectInfo(i);
		String expected = 
				"Type: [Ljava.lang.Integer;\n"
				+ "\t[0]\n"
				+ "\tType: java.lang.Integer\n"
				+ "\t\tValue : 0\n"
				+ "\t[1]\n"
				+ "\tType: java.lang.Integer\n"
				+ "\t\tValue : 1\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void matrixTest() throws IllegalArgumentException, IllegalAccessException {
		Integer[][] i = new Integer[][]{new Integer[]{0,1},new Integer[]{2,3}};
		String result = Logger.getObjectInfo(i);
		String expected = 
				"Type: [[Ljava.lang.Integer;\n"
				+ "\t[0]\n"
				+ "\tType: [Ljava.lang.Integer;\n"
				+ "\t\t[0]\n"
				+ "\t\tType: java.lang.Integer\n"
				+ "\t\t\tValue : 0\n"
				+ "\t\t[1]\n"
				+ "\t\tType: java.lang.Integer\n"
				+ "\t\t\tValue : 1\n"
				+ "\t[1]\n"
				+ "\tType: [Ljava.lang.Integer;\n"
				+ "\t\t[0]\n"
				+ "\t\tType: java.lang.Integer\n"
				+ "\t\t\tValue : 2\n"
				+ "\t\t[1]\n"
				+ "\t\tType: java.lang.Integer\n"
				+ "\t\t\tValue : 3\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void objectTest() throws IllegalArgumentException, IllegalAccessException {
		ClassRoom cr = new ClassRoom();
		String result = Logger.getObjectInfo(cr);
		String expected ="Type: com.talosdigital.kata.reflectionTest.ClassRoom\n"
				+ "\tAttributes: \n"
				+ "\t\tstudents\n"
				+ "\t\tType: [Lcom.talosdigital.kata.reflectionTest.Person;\n"
				+ "\t\t\t[0]\n"
				+ "\t\t\tType: com.talosdigital.kata.reflectionTest.Person\n"
				+ "\t\t\t\tAttributes: \n"
				+ "\t\t\t\t\tname\n"
				+ "\t\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\t\tValue : Pepito\n"
				+ "\t\t\t\t\tlastName\n"
				+ "\t\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\t\tValue : Perez\n"
				+ "\t\t\t\t\tage\n"
				+ "\t\t\t\t\tType: java.lang.Integer\n"
				+ "\t\t\t\t\t\tValue : 15\n"
				+ "\t\t\t[1]\n"
				+ "\t\t\tType: com.talosdigital.kata.reflectionTest.Person\n"
				+ "\t\t\t\tAttributes: \n"
				+ "\t\t\t\t\tname\n"
				+ "\t\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\t\tValue : Mateo\n"
				+ "\t\t\t\t\tlastName\n"
				+ "\t\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\t\tValue : Carvajal\n"
				+ "\t\t\t\t\tage\n"
				+ "\t\t\t\t\tType: java.lang.Integer\n"
				+ "\t\t\t\t\t\tValue : 16\n"
				+ "\t\tteacher\n"
				+ "\t\tType: com.talosdigital.kata.reflectionTest.Person\n"
				+ "\t\t\tAttributes: \n"
				+ "\t\t\t\tname\n"
				+ "\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\tValue : Juan\n"
				+ "\t\t\t\tlastName\n"
				+ "\t\t\t\tType: java.lang.String\n"
				+ "\t\t\t\t\tValue : Henao\n"
				+ "\t\t\t\tage\n"
				+ "\t\t\t\tType: java.lang.Integer\n"
				+ "\t\t\t\t\tValue : 25\n";
		assertEquals(expected,result);
	}
	

}
