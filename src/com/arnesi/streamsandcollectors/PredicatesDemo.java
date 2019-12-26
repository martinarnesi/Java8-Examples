package com.arnesi.streamsandcollectors;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicatesDemo {

	public static void main(String[] args) {
		//Creando Predicados
		Stream<String> stream1 = Stream.of("uno","dos","tres","cuatro","cinco");
				
		Predicate<String> p1 = s -> s.length() > 3; //Filtrar cadenas mayores a 3 caracteres
		stream1.filter(p1).forEach(System.out::println); //Method reference.
		
		
		//Combinando Predicados
		Stream<String> stream2 = Stream.of("uno","dos","tres","cuatro","cinco");
		Predicate<String> p2 = Predicate.isEqual("dos");
		Predicate<String> p3 = Predicate.isEqual("tres");
		stream2.filter(p2.or(p3)).forEach(System.out::println); //Solo imprime dos y tres
	}
}
