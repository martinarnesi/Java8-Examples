package com.arnesi.streamsandcollectors;

public class Person {
	
	private String name;
	private Integer age;
	
	public Person (String name, Integer age) {
		this.name = name;
		this.age = age;
		
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}