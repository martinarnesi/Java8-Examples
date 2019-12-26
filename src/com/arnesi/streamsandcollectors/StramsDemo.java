package com.arnesi.streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StramsDemo {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("uno", "dos", "tres");
		
		//Creacion de un Stream
		Stream<String> stream = stringList.stream();
		
		//stream.forEach(s -> System.out.println(s));
		stream.forEach(System.out::println); //Method Reference
		
		
		//Filtrando un Stream
		Person p1 = new Person("Martin", 41);
		Person p2 = new Person("Pablo", 40);
		Person p3 = new Person("Adrian", 19);
		
		List<Person> personList = Arrays.asList(p1,p2,p3);

		Stream<Person> personStream = personList.stream();
		
		//Filtrando
		Stream<Person> filteredPersonStream = personStream.filter(Person -> Person.getAge() > 20);
		filteredPersonStream.forEach(p -> System.out.println(p.getName()));
	}
}