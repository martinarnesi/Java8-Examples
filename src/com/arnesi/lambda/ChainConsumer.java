package com.arnesi.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {
	
	public static void main(String... args) {
		
		List<String> strings = Arrays.asList("uno","dos","tres","cuatro");
		List<String> result = new ArrayList<>();
		
		Consumer<String> c1 = System.out::println;
		
		//Consumer<String> c2 = s -> result.add(s); // Forma Simple
		Consumer<String> c2 = result::add; // Method Reference 
		
		strings.forEach(c1.andThen(c2)); //consumo c1 y luego se lo envio a c2
		
		System.out.println("Size of result=" + result.size());
	}
}
