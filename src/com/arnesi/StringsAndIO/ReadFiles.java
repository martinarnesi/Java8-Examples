package com.arnesi.StringsAndIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFiles {
	
	private final static String PATH = "sandbox\\training\\springTraining\\Java-8-Examples\\src\\com\\arnesi\\dateandtime\\"; 
	
	public static void main(String[] args) {
		
		Path path = Paths.get("c:", "windows");

		//Java 7 - Try with resources
		//try (Stream<Path> stream = Files.walk(path, 2)) //Revisa subdirectorios con una profundidad de 2 subniveles
		try (Stream<Path> stream = Files.list(path)) {
			stream.filter(p -> p.toFile().isDirectory()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
