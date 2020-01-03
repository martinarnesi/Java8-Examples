package com.arnesi.streamsandcollectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {
	
	public static void main(String... args) {
		
		List<Person> persons = new ArrayList<>();
		
		//Try with Resources
		try (
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(
							CollectorsExample.class.getResourceAsStream("people.txt")));
			
				Stream<String> stream = reader.lines(); //Retorna un Stream of stings
			
		) {
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
				}).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();;
		}
		
		Stream<Person> stream = persons.stream();
		
		//Persona mas joven, pero que sea mayor de 20
		Optional<Person> opt =	stream.filter(p -> p.getAge() >= 20)
				.min(Comparator.comparing(Person::getAge));
		System.out.println("Persona mas joven mayor de 20 añostene= "+opt);
		
		
		//Persona mas vieja
		// Optional<Person> opt2 = stream.max(Comparator.comparing(Person::getAge));
		// System.out.println("Persona mas vieja"+ opt2);
		
		/* NOTA: stream has already been operated upon or closed --> No puedo usar 2 final Operationsel mismo stream, una vez que se cerro
		 Requiero crear otro stram. */
		
		Stream<Person> stream2 = persons.stream();
		Optional<Person> opt2 = stream2.max(Comparator.comparing(Person::getAge));
		//Podria usar Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));
		System.out.println("Persona mas vieja"+ opt2);
				
		
		/*COLLECTORS*/
		Map<Integer, List<Person>> map2 = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Map de personas por edad"+ map2);
		
		//Me interesa el listado de nombres por edad dentro de un mapa
		Map<Integer, List<String>> map3 = persons.stream()
				.collect(
						Collectors.groupingBy(
								Person::getAge, 
								Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("Map de personas por edad como clave y nombres en la lista"+ map3);
		
		

	}
}
