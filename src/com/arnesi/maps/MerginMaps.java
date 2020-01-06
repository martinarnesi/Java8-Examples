package com.arnesi.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MerginMaps {
	
	private final static String PATH = "sandbox\\training\\springTraining\\Java-8-Examples\\src\\com\\arnesi\\maps"; 
	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
	
		//Java 7
		Path path = Paths.get("c:", PATH, "people.txt");	
		
		//Try with Resources
		try (
			//java 7 Files.lines() - Nueva forma de leer archivos, desde Java 7
			Stream<String> stream = Files.lines(path); 
		) {
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
				
				persons.add(p);
				return p;
			})
			.forEach(System.out::println);;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("*************Person List*************");
		persons.forEach(System.out::println);
		
		List<Person> list1 = persons.subList(0, 5);
		List<Person> list2 = persons.subList(5, persons.size());
		
		Map<Integer, List<Person>> personsMap1 = mapByAge(list1);
		System.out.println("Map 1");
		personsMap1.forEach((age, list) -> System.out.println(age + "-> " +list));

		Map<Integer, List<Person>> personsMap2 = mapByAge(list2);
		System.out.println("Map 2");
		personsMap2.forEach((age, list) -> System.out.println(age + "-> " +list));
		
		//Mergear contenido de Map1 y Map 2
		personsMap2.entrySet().stream()
						.forEach(
								entry -> 
									personsMap1.merge(
											entry.getKey(),
											entry.getValue(),
											(l1, l2) -> {l1.addAll(l2); return l1;})
								);
		System.out.println("Map 1 Merge");
		personsMap1.forEach((age, list) -> System.out.println(age + "-> " +list)); 
	}
	
	private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
		return list.stream().collect(Collectors.groupingBy(Person::getAge));
	}
}