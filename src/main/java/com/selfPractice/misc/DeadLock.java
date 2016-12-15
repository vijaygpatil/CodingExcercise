package com.selfPractice.misc;

public class DeadLock {
	/* * This method request two locks, first String and then Integer */
	public void method1() {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			}
		}
	}

	/*
	 * * This method also requests same two lock but in exactly * Opposite order
	 * i.e. first Integer and then String. * This creates potential deadlock, if
	 * one thread holds String lock * and other holds Integer lock and they wait
	 * for each other, forever.
	 */
	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}
	
	// ANOTHER WAY

	String str1 = "Java";
	String str2 = "UNIX";

	Thread trd1 = new Thread("My Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	};

	Thread trd2 = new Thread("My Thread 2") {
		public void run() {
			while (true) {
				synchronized (str2) {
					synchronized (str1) {
						System.out.println(str2 + str1);
					}
				}
			}
		}
	};

	public static void main(String a[]) {
		DeadLock mdl = new DeadLock();
		mdl.trd1.start();
		mdl.trd2.start();
	}
}
