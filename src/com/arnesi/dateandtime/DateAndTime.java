package com.arnesi.dateandtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class DateAndTime {
	public static void main(String... args) {
		
		List<Person> persons = new ArrayList<>();
		
		//Try with Resources
		try (
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(
							DateAndTime.class.getResourceAsStream("people.txt")));
			
				Stream<String> stream = reader.lines(); //Retorna un Stream of stings
			
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
