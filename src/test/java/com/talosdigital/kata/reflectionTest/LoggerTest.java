package com.talosdigital.kata.reflectionTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LoggerTest{
	
	@Test
	public void PrimitiveTest() throws IllegalArgumentException, IllegalAccessException  {
		int i = 10;
		String result = Logger.getObjectInfo(i);
		String expected = "Type: java.lang.Integer\n\tValue : 10\n";
		System.out.println(result);
		assertEquals(expected, result);
	}
	
	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		Thread t = new Thread();
		int[][] i  = new int[2][2];
		String a =new String("asd");
		Person p =new Person(0);
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
