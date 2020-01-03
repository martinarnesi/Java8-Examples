package com.arnesi.streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
	
	public static void main(String[] args) {
		//SUM
		List<Integer> list = Arrays.asList(6,12,2);
		//Integer sum = list.stream().reduce(0, (s1, s2) -> s1 + s2);
		Integer sum = list.stream().reduce(0, Integer::sum); //Method reference
		System.out.println("Sum="+ sum);
		
		//MAX (no tiene Identity value)
		List<Integer> list2 = Arrays.asList(-12,10,0);
		Optional<Integer> max = list2.stream().reduce(Integer::max); //Method reference
		System.out.println("Max="+ max);
	}
}
