package com.arnesi.dateandtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class DateAndTime {
	
	private final static String PATH = "sandbox\\training\\springTraining\\Java-8-Examples\\src\\com\\arnesi\\dateandtime\\"; 
	
	public static void main(String... args) {
		
		List<Person> persons = new ArrayList<>();
		
		//Java 7
		Path path = Paths.get("c:",PATH, "people.txt");	
		
		//Try with Resources
		try (
			//java 7 Files.lines() - Nueva forma de leer archivos, desde Java 7
			Stream<String> stream = Files.lines(path); 
		) {
			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]);
				Month month = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);
				
				//Java 8 
				Person p = new Person(name, LocalDate.of(year, month, day));
				
				persons.add(p);
				return p;
				}).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();;
		}
		
		LocalDate now = LocalDate.now();
		
		//Imprimir los años y los dias que pasaron desde la fecha de nacimiento dentro de people.txt
		persons.stream().forEach(
					p -> {
						Period period = Period.between(p.getDateOfBirth(), now);
						System.out.println(p.getName() +" was born "
								+period.get(ChronoUnit.YEARS)+ " and "
								+period.get(ChronoUnit.MONTHS) + "months"
								);
					}
				);
	}
}
