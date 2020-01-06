package com.arnesi.StringsAndIO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	public static void main(String[] args) {
		
		Person p1 = new Person("Martin", "Arnesi");
		Person p2 = new Person("Pablo", "Zalino");
		Person p3 = new Person("Marcos", "Arnesi");
		Person p4 = new Person("Juan Manuel", "Arnesi");
		Person p5 = new Person("Marcelo", "Moyano");
		
		List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);
	
		//Comparator using lambda expressions and the comparing() static factory method.
		Comparator<Person> compareLastNameThenFirstName = 
				Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName);

		Collections.sort(personList, compareLastNameThenFirstName);
		
		personList.stream().forEach(System.out::println);
	}
}
