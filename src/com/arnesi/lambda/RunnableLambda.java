package com.arnesi.lambda;

public class RunnableLambda {
	
	public static void main(String... args) throws InterruptedException {
		
		
		/*Anonimous class*/
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello world from thread " + Thread.currentThread().getName());
				}
				
			}
		};
		
		/*Lambda Expression*/
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello world from thread " + Thread.currentThread().getName());
			}
		};
		
		Thread t = new Thread(runnableLambda);
		
		t.start();
		t.join();
	}
}
