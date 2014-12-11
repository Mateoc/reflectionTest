package com.talosdigital.kata.reflectionTest;

import java.util.Random;

public class Person {
	public String name;
	public String lastName;
	public int age;
	
	public Person (String name, String lastName, int age){
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Person (int x){
		switch(x){
			case 0:{
				name = "Pepito";
				lastName ="Perez";
				age = 15;
				break;
			}
			case 1:{
				name = "Mateo";
				lastName = "Carvajal";
				age = 16;
				break;
			}
			 default:{
				name = "Juan";
				lastName = "Henao";
				age = 25;
				break;
			}
		}
	}
}
