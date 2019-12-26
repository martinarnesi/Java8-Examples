package com.arnesi.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

	public static void main(String[] args) {
		
		File dir = new File("C:\\sandbox\\training\\springTraining\\Java-8-Examples\\src\\com\\arnesi\\lambda\\");

		/**Implementacion usando clases anonimas, algo viejo ya.**/
		FileFilter filterAnonimo = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
	 			return file.getName().endsWith(".java");
			}
		};
		
		System.out.println("************* Usando Clases anonimas*******************");
		File[] files = dir.listFiles(filterAnonimo);
		for (File file : files) {
			System.out.println(file);
		}
		
		
		/**Implementacion de la Interfaz FileFilter usando lambdas, mas limpio y simple de leer **/
		FileFilter filterLambda = (File file) -> file.getName().endsWith(".java");
			
		File[] filesLambda = dir.listFiles(filterLambda);
		System.out.println("************* Usando Lambdas*******************");
		for (File fileLambda : filesLambda) {		
			System.out.println(fileLambda);
		}
		
		
		/** Procesar colleccion con Lambdas**/
		List<String> stringList = new ArrayList<>();
		stringList.add("uno");
		stringList.add("dos");
		stringList.add("tres");
		
		//Opcion 1
		stringList.forEach(String -> System.out.println(String));
		//Opcion 2 - Simplificado --> Method Reference 
		stringList.forEach(System.out::println);
		
		
		//Predicados
		Predicate<String> p1 = s -> s.length() < 20;
		Predicate<String> p2 = s -> s.length() > 10;
		
		Predicate<String> p3 = p1.and(p2);
		
		System.out.println("-->"+p3.toString());
	}
}
