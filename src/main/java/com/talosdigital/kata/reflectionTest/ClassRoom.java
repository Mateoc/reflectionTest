package com.talosdigital.kata.reflectionTest;

public class ClassRoom {
	public Person[] students;
	public Person teacher;
	
	public ClassRoom(){
		students = new Person[]{new Person(0), new Person(1)};
		teacher = new Person(2);
	}
}
