package com.arnesi.streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlapMapDemo {
	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);
		
		//Lista de listas
		List<List<Integer>> listas = Arrays.asList(list1, list2, list3);
		System.out.println(listas);
		
		//FlapMap (Combinacion de las operaciones de MAP y FLAT. Primero aplica MAP y luego aplica flattens (aplana) la lista.
		Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();
		listas.stream()
			.flatMap(flatmapper)
			.forEach(r -> System.out.print(r+","));
	}
}
